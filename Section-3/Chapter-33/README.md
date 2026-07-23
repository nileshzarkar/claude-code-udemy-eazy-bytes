https://github.com/nileshzarkar/job-portal-ui/blob/master/.github/workflows/claude-code-review.yml
https://github.com/nileshzarkar/job-portal-ui/blob/master/.github/workflows/claude.yml

These two files are independent GitHub Actions workflows. They both use the same Claude Action (anthropics/claude-code-action@v1), but they are triggered by different GitHub events.

Think of them as two different switches that can call the same Claude service.

                    GitHub Repository
                           │
          ┌────────────────┴────────────────┐
          │                                 │
          ▼                                 ▼
claude-code-review.yml                claude.yml
(Auto Review)                        (@claude Assistant)
          │                                 │
          └──────────────┬──────────────────┘
                         ▼
         anthropics/claude-code-action@v1
                         │
                         ▼
                 Claude (Anthropic)

Workflow 1: claude-code-review.yml
What is its job?
    Its only job is:  Whenever a Pull Request is opened or updated, automatically ask Claude to review it.
    Think of it as: "A new PR arrived. Claude, please review it."
Step by step
1. PR is opened
    on:
    pull_request:
    Means: Developer opens PR
    Example:
    feature/login
        │
        ▼
    Create Pull Request
    GitHub notices this.

2. GitHub starts the workflow
    GitHub
        │
        ▼
    Run claude-code-review.yml

3. Checkout repository
    uses: actions/checkout@v4
    Meaning: Download the repository onto the temporary GitHub Actions machine.
        GitHub Runner
        Downloads repository
    Claude cannot review code unless the code is available.

4. Call Claude
    uses: anthropics/claude-code-action@v1
    This is the important step.
    It means: Invoke Claude.

5. Tell Claude what to do
    prompt: 
    /code-review:code-review repository/pull/123
    This is like telling Claude: "Please review Pull Request #123."
    Claude then
    - reads changed files
    - understands the code
    - posts review comments.

So the entire workflow is simply
    New PR
        │
    GitHub Action
        │
    Call Claude
        │
    Claude reviews code
        │
    Posts review comments
No human has to ask Claude.






Workflow 2: claude.yml
    This one behaves very differently.
    Its purpose is
        Only run Claude when someone explicitly tags @claude.
    For example
    Someone writes
        @claude
        Can you explain this function?
    or
        @claude
        Please fix this bug.
    GitHub notices
        A comment was created
    and starts this workflow.



The "if" statement
This part
    contains(github.event.comment.body, '@claude')
simply means : Does the comment contain @claude?
If
    Looks good.
➡️ Claude does nothing.

If
    @claude explain this
➡️ Claude wakes up.
Then exactly like before
    Checkout repository
    ↓
    Run Claude Action
    ↓
    Claude reads repository
    ↓
    Claude replies



What does additional_permissions
    actions: read
mean?
Imagine Claude says
    "Let me also look at your build."

Without permission
    Claude
    │
    X
    Cannot read CI results

With
    actions: read
    Claude can read
    - Build status
    - Test results
    - Failed jobs

So if someone asks
    @claude
    Why did my build fail?
Claude can inspect GitHub Actions logs before answering.



How are they related?
They both use
uses:
anthropics/claude-code-action@v1
This is the same GitHub Action.
Think of it like this.

                    Claude Action
                         ▲
                         │
        ┌────────────────┴───────────────┐
        │                                │
Automatic Review                  @claude Assistant
Same Claude.
Different trigger.



Do they call each other?
No.
One workflow never starts the other.
GitHub decides which workflow to run based on the event.

For example
    Open PR
        Only claude-code-review.yml runs.

If someone comments
    @claude
    Can you optimize this?
        Only claude.yml runs.

Both could run on the same PR, but for different reasons.
Example:
Developer opens PR
⬇
GitHub automatically runs
claude-code-review.yml

Claude reviews the code.
Later the reviewer comments
    @claude
    Can you explain this SQL query?
⬇
GitHub now runs claude.yml
Claude answers that specific question.
So the sequence looks like:
Open PR
    │
    ▼
claude-code-review.yml
    │
    ▼
Claude posts automatic review

        (later)

Reviewer writes:
"@claude Explain this function."
    │
    ▼
claude.yml
    │
    ▼
Claude replies to that specific request


One-line summary
claude-code-review.yml 
Automatic reviewer. It reviews every new or updated PR without anyone asking.

claude.yml 
On-demand assistant. It only wakes up when someone mentions @claude in an issue, PR review, or comment. 
Both workflows use the same underlying Claude GitHub Action, but they are independent and serve different purposes.

https://github.com/anthropics/claude-code/tree/main/plugins
This is the place where the plugins are saved 
Instead, think of them as pre-built AI capabilities that teach Claude how to perform specific tasks.

If you open these empty file here, they have given instructions on how the Claude it has to react when someone triggered the slash command.
https://github.com/anthropics/claude-code/blob/main/plugins/code-review/commands/code-review.md
This file is essentially the playbook that tells Claude how to perform a code review. It's not code—it's a detailed set of instructions.
Overall goal
Review a Pull Request like an experienced senior engineer and only report real, high-confidence issues.
Step-by-step summary
Step 1: Should I review this PR?
Step 2: Read project rules
Step 3: Understand the PR
Step 4: Review in parallel
Step 5: Validate every issue
Step 6: Keep only confirmed issues
Step 7: Produce the review
Step 8: Prepare comments
Step 9: Post inline GitHub comments


github_token: ${{ github.token }}
    Every time a GitHub Action runs, GitHub automatically creates a temporary access token just for that workflow.
    Think of it as a temporary ID card.
        GitHub Action starts
                │
                ▼
        GitHub creates a temporary token
                │
                ▼
        Claude uses this token to talk back to GitHub
    Without this token, Claude can read the code but cannot post comments, update the PR, or report its status back to GitHub.

track_progress: true
    This tells Claude:
        "Keep GitHub updated with your progress while you're working."
    Instead of waiting silently until the review finishes, Claude can report things like:
    - 🔄 Starting review
    - 🔍 Analyzing files
    - ✅ Review completed
    This lets you see that the review is actively running.


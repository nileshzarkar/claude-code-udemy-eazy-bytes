GitHub Actions Integration (@claude Bot) – Simplified Explanation
Claude Code can run as a GitHub bot inside your repository using GitHub Actions.
Instead of opening Claude on your computer, you can ask Claude to do work directly from GitHub.

What can the @claude bot do?
You can ask it to:
    💬 Answer questions about your code.
    🔍 Review Pull Requests (PRs) and suggest improvements.
    🛠️ Fix bugs or implement small features.
    📋 Read GitHub Issues and create solutions.
    ✅ Update progress on GitHub as it works.

How do you use it?
In a GitHub PR or Issue comment, simply mention Claude.
Examples:
    @claude Review this PR.
    @claude Fix this bug.
    @claude Explain this code.

What happens behind the scenes?
👤 You mention @claude in a GitHub comment.
⚙️ GitHub Actions automatically starts a workflow.
📖 Claude reads:
    Your project code.
    The CLAUDE.md file (project instructions).
🤖 Claude performs the requested task.
📝 Claude posts the result back on GitHub as a comment, code review, commit, or even a new Pull Request.

Example Workflow
Suppose someone reports a bug.
GitHub Issue:
    Login button doesn't work.
You comment:
    @claude Fix this bug.
Claude will:
    Read the issue.
    Find the relevant code.
    Fix the problem.
    Commit the changes.
    Create a Pull Request.
    Comment with what it changed.
Everything happens inside GitHub, without you opening Claude Code locally.

Key takeaway
The @claude bot lets you use Claude directly from GitHub. 
By mentioning @claude in an Issue or Pull Request, GitHub Actions automatically runs Claude, which analyzes your code, performs the requested task, and posts the results back to GitHub.









Setting Up the @claude GitHub Bot – Simplified Explanation
This slide explains how to enable the @claude bot in your GitHub repository.
Step 1: Install the Claude GitHub App
    Open Claude Code in your project and run: /install-github-app
    Claude will guide you through the setup.
Step 2: Install the GitHub App
    Follow the prompts.
    Claude installs the Claude GitHub App into your GitHub repository so it can respond to @claude mentions.
Step 3: Add the GitHub Workflow
    Claude automatically creates a Pull Request containing a workflow file: .github/workflows/claude.yml
    This workflow tells GitHub Actions how to start Claude whenever someone mentions @claude.
    Before merging this PR, add your Anthropic API Key as a GitHub Secret:
    Repository
    ↓
    Settings
    ↓
    Secrets and Variables
    ↓
    Actions
    ↓
    New Repository Secret
    Name: ANTHROPIC_API_KEY
    Value: <your Anthropic API Key>
    This allows GitHub Actions to securely authenticate with Claude.
Step 4: Merge the Pull Request
    Once the secret is added, merge the PR.
    Your repository is now ready to use the @claude bot.
Step 5: Test It
    Go to any Pull Request or GitHub Issue and comment:
    @claude review this PR
    or
    @claude fix this bug
    GitHub Actions will automatically start Claude, and the bot will review the PR or work on the issue.

Complete Flow
1. Run /install-github-app
        ↓
2. Install Claude GitHub App
        ↓
3. Claude creates .github/workflows/claude.yml
        ↓
4. Add ANTHROPIC_API_KEY as a GitHub Secret
        ↓
5. Merge the Pull Request
        ↓
6. Use @claude in PRs or Issues

Key takeaway
Setting up the @claude bot is a one-time process. 
After installing the GitHub App, adding the ANTHROPIC_API_KEY secret, and merging the workflow, anyone can use @claude in GitHub Issues or Pull Requests to ask Claude to review code, fix bugs, or answer questions.



─────────────────────────────────────────────────────────────────────────────────────────────────────
❯ /install-github-app
─────────────────────────────────────────────────────────────────────────────────────────────────────

─────────────────────────────────────────────────────────────────────────────────────────────────────
> Use current repository: nileshzarkar/job-portal-ui
  Enter a different repository 
─────────────────────────────────────────────────────────────────────────────────────────────────────
ENTER

https://github.com/apps/claude
It will ask upip to install Claude Github App

Note:
The GitHub App is not GitHub Actions. It works alongside GitHub Actions.
Think of the Claude GitHub App as an AI teammate that works inside your GitHub repository.
What does the Claude GitHub App do?
Once installed, it can:
    Review Pull Requests (PRs)
    Explain code
    Suggest fixes
    Answer questions about your repository
    Generate code
    Help debug CI failures
    Summarize changes

Important:
The key point is that the Claude GitHub App is not installed on your computer or inside your GitHub repository. It's installed into your GitHub account or organization as a GitHub App
GitHub registers the Claude GitHub App with your account or organization.
You're not downloading software to your laptop; you're granting an external service permission to interact with your GitHub repositories.
The app now appears under Settings → Applications → Installed GitHub Apps (or the organization's installed apps).

─────────────────────────────────────────────────────────────────────────────────────────────────────
 GitHub App installed!
 Set up GitHub Actions
 
 The Claude GitHub App is now installed. You can optionally set up GitHub Actions workflows so Claude responds to @claude mentions in issues and PRs.

❯ 1. Set up GitHub Actions workflows
  2. Skip for now (you can run /install-github-app again later)
─────────────────────────────────────────────────────────────────────────────────────────────────────



▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔
   Select GitHub workflows to install
   We'll create a workflow file in your repository for each one you select.

   More workflow examples (issue triage, CI fixes, etc.) at: https://github.com/anthropics/claude-code-action/blob/main/examples/

   ❯ [✔] @Claude Code - Tag @claude in issues and PR comments
     [✔] Claude Code Review - Automated code review on new PRs

   ↑/↓ to navigate · Space to toggle · Enter to confirm · Esc to cancel
▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔
By default both of them are selected , ENTER to confirm

Note: 
1. @Claude Code - Tag @claude in issues and PR comments
This workflow says:
"Whenever someone mentions @claude in a GitHub Issue or Pull Request comment, ask Claude to respond."
A developer comments on a PR:
    @claude Can you explain this code?
What happens:
    Developer
        │
        ▼
    Writes "@claude ..."
        │
        ▼
    GitHub Action starts
        │
        ▼
    Calls Claude
        │
        ▼
    Claude reads the repository
        │
        ▼
    Claude posts a reply    

2. Claude Code Review - Automated code review on new PRs
This workflow says:
"Whenever a new Pull Request is created (or updated), automatically ask Claude to review the code."
No one needs to type @claude.
Example
    Developer opens PR
GitHub automatically starts the workflow.
    New Pull Request
            │
            ▼
    GitHub Action starts
            │
            ▼
    Calls Claude
            │
            ▼
    Claude reviews code
            │
            ▼
    Comments on the PR    

▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔
Install GitHub App
Choose API key

  Create a long-lived token with your Claude subscription
> Enter a new API key
▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔

Enter the Anthropic API key

THis will automtically create new PR for the Claude Code Github App workflow 
Add Claude Code GitHub Workflow
master <> add-claude-github-actions-1784563810904

Files created :
.github/workflows/claude-code-review.yml
.github/workflows/claude.yml

Important: Add this in claude-code-review.yml
...
        with:
          anthropic_api_key: ${{ secrets.ANTHROPIC_API_KEY }}
          github_token: ${{ github.token }}
          track_progress: true
          plugin_marketplaces: 'https://github.com/anthropics/claude-code.git'
          plugins: 'code-review@claude-code-plugins'
...


Merge this PR .
So this gets merged in master of https://github.com/nileshzarkar/job-portal-ui






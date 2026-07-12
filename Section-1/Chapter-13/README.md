Claude Code settings let you control how Claude behaves while working on your project.
With settings, you can decide:
✅ What Claude is allowed to do.
❌ What Claude is not allowed to do.
📂 How Claude interacts with your codebase.
🔗 How Claude works with external tools.

Think of Claude Code settings as a control panel where you customize Claude's behavior to suit your development workflow and preferences.

Why do we need Claude Code Settings?
Claude Code settings let you customize Claude's behavior to match your development style and project needs.

Why are they needed?
1. Avoid repeated permission prompts (e.g., approving every file edit or command).
2. Control Claude's actions based on your comfort level and risk tolerance.
3. Different settings for different projects, such as prototyping vs. production.
4. Allow or block specific actions or tools according to your preferences.
5. Improve productivity by reducing unnecessary interruptions while maintaining the desired level of safety.

Key takeaway
Claude Code settings allow you to personalize how Claude works, making it fit your workflow instead of forcing you to follow the default behavior.

Various approaches to work on Claude Code Settings

Approach 1 - The /config command (Interactive UI)
=================================================
This is the most beginner-friendly way to control Claude Code.
When you run /config inside the REPL, it opens a tabbed Settings interface right in your terminal—a one-stop shop to view status and change configuration options without touching any files manually.
PS D:\AI\claude-code-udemy-eazy-bytes\Section-1\Chapter-13> claude

  /config                       Open settings
  /update-config                Use this skill to configure the Claude Code harness via settings.json. Automated 
───────────────────────────────────────────────────────────────────────────────────────────
❯ /config
───────────────────────────────────────────────────────────────────────────────────────────

Auto-Compact Setting (Simplified)
Auto-Compact automatically summarizes your conversation when it becomes too long.
Instead of keeping the entire chat history, Claude creates a short summary of the important points and continues working from that summary.

Why is it useful?
- Prevents the conversation from becoming too large.
- Saves context space (token usage).
- Allows longer conversations without losing the main context.

Example
Suppose you've been chatting with Claude for 2 hours about a Quarkus project.
Instead of remembering every message, Auto-Compact creates a summary like:
"User is working on a Quarkus 3 microservice using Java 21. Constructor injection is required. JUnit 5 should be used. Currently implementing User Management."
Claude then continues the conversation using this summary instead of the full chat history.

----

Think of context as Claude's working memory.
Every message you send and every response Claude gives is stored in that working memory. The more conversation there is, the more tokens it uses.
Without Auto-Compact
Suppose your conversation is:
    Message 1 - 500 tokens
    Message 2 - 700 tokens
    Message 3 - 800 tokens
    ...
    Total = 20,000 tokens
When you ask the next question, Claude has to read those 20,000 tokens again to understand the context.

With Auto-Compact

Claude summarizes the conversation into something like:

Summary:
- User is building a Quarkus project.
- Using Java 21.
- Following constructor injection.
- Currently implementing User Management.

This summary might be only 500 tokens instead of 20,000 tokens.
Now, for your next question, Claude reads:
    500-token summary instead of
    20,000-token full conversation

Why does this save tokens?
Because less text needs to be kept and processed.
    Without Auto-Compact:
    20,000 tokens
    ↓
    With Auto-Compact:
    500-token summary
Claude spends fewer tokens understanding the previous conversation, leaving more context space available for future messages.    
===

Apart from config we also have Usage tab
This is the Usage tab in Claude Code's /config screen. It shows how much of your Claude usage limits you've consumed, especially if you're using a Claude subscription (such as Pro).
Session
    Total cost: $0.0000
        The API cost for this session.
        If you're using your Claude Pro login, this is usually $0.00 because you're not paying per API request.
        If using an API key, this would show the API charges.
    Total duration (API): 0s
        Time spent making API requests.
        0s means no API-key requests were made.
    Total duration (wall): 14m 47s
        The actual time you've had this Claude session open.
    Total code changes
        Shows how many lines Claude has added or removed.
        Yours shows 0 lines added, 0 removed, meaning no files have been modified yet.
Usage
    Shows token/cache statistics:
        Input = Tokens you sent.
        Output = Tokens Claude generated.
        Cache read/write = Tokens reused from prompt caching.
    Yours is 0 because no prompts have been processed in this session.

Apart from config we also have Status tab
The Status tab gives you a quick overview of your current Claude Code environment. It's the first place to check if something isn't working.

Explanation of each field
Version : 2.1.207 : The version of Claude Code you're using.
Session name : /rename to add a name : An optional name for your current session. : Helps identify the session later if you resume it.
Session ID : 07552db3-... : A unique ID for the current session.
Login Method : Claude Pro account : Shows how you're authenticated.
Examples: Claude Pro account / API Key / Enterprise account / 
Organization : nileshzarkar@gmail.com's Organization : Shows which Claude organization/account you're using.
Email : nileshzarkar@gmail.com : The account currently logged in.
Model : Opus (claude-opus-4-8) : Shows which AI model is currently active.
IDE : Connected to VS Code extension version 2.1.207 : Confirms Claude is connected to VS Code.
MCP Servers : 1 need auth : Shows the status of connected MCP (Model Context Protocol) servers.
Setting Sources : 
    User settings : Indicates where Claude loaded its settings from.
    It could be: User settings / Project settings / Organization settings

───────────────────────────────────────────────────────────────────────────────────────────
❯ /usage
───────────────────────────────────────────────────────────────────────────────────────────
Now this time, if I directly type usage command, it is going to show the same config panel,
but this time by default, the usage tab is going to be displayed.

---

───────────────────────────────────────────────────────────────────────────────────────────
❯ /status
───────────────────────────────────────────────────────────────────────────────────────────
The other approach to land onto the status tab is by using the status slash command.
If I press enter, I will be landed onto the status tab by default.

---

/permissions – A dedicated interactive UI for managing allow, deny, and ask permission rules. Changes take effect immediately without requiring a restart.

/model – Opens an interactive menu to quickly switch between AI models during the current Claude Code session.

Approach 2 - CLI arguments (Per-Session Overrides)
==================================================
These are temporary options that you pass when starting Claude Code. They only affect the current session and do not modify your configuration files.

1. Quick model switching
    Argument : --model <model-name>
    What it means
    Tell Claude which AI model to use for this session only.
    Example
    Normally you use Sonnet: claude
    Need a stronger model for a difficult architecture discussion?
        claude --model opus
    What happens?
    Only this session uses Opus.
    Next time you simply run claude it goes back to your default model (Sonnet).
    Real-life example
    Suppose you're:
    Writing Java code → Sonnet is enough.
    Designing a distributed microservice architecture → Switch to Opus.
    Instead of permanently changing settings, just do: claude --model opus

2. Multi-repo workflows
Argument : --add-dir <directory>
What it means
Allow Claude to read another folder/repository in addition to the current one.
Normally Claude only sees the folder where you launched it.
Example
Current structure:
Projects/
   frontend/
   backend/
You start Claude inside: frontend
Normally Claude only knows: frontend/

If you run:
claude --add-dir ../backend
Claude now knows both:
frontend/
backend/
Why is this useful?
Suppose:
Frontend calls
POST /users
but you want Claude to check whether the backend actually has that API.
Without --add-dir
Claude cannot inspect the backend.
With
--add-dir ../backend
Claude can compare both projects.

3. CI/CD and scripting
The slide is saying CLI arguments in general are mainly used in automation.
Why?
In GitHub Actions, Jenkins, Azure DevOps, etc., there is no interactive terminal where someone can answer questions.
Everything must be provided as command-line options.
Example:
claude \
  --model sonnet \
  --add-dir ../shared-library
This command can run automatically inside a pipeline.
Real-life example
Your GitHub Action might execute:
Checkout code
↓
Run tests
↓
Run Claude review
↓
Generate documentation
Nobody is sitting there typing commands.
Everything must be specified beforehand.

4. Testing with relaxed permissions
This refers to temporarily giving Claude more permissions.
Example argument (varies depending on version):  --dangerously-skip-permissions
or another permission-related flag.
What it means
Normally Claude asks before:
    Editing files
    Running commands
    Accessing directories

With this flag it may skip some confirmations.
Example

Normal mode
Claude: May I edit pom.xml?
You answer: Yes

YOLO mode
Claude edits automatically.

Why temporary?
You may want to test it once.
Instead of permanently changing settings:
permissions = relaxed
you simply run
claude --dangerously-skip-permissions
When you close Claude, permissions return to normal.


============

1. --model <model-name>
What it does
Starts Claude with a specific AI model.
Syntax : 
claude --model sonnet  or  claude --model opus
Example
Normally:
claude
Uses your default model.
Need a stronger model for a difficult task?
claude --model opus
Only this session uses Opus.

2. --add-dir <path>
What it does
Allows Claude to access another folder or repository.
Example
Suppose your project is:
Projects
│
├── frontend
└── backend
You start Claude inside frontend.
Normally Claude only sees:
frontend/
Run:
claude --add-dir ../backend
Now Claude can access:
frontend/
backend/
Real example
You ask:
"Why is my frontend getting a 404 error?"
Claude can inspect both the frontend code and the backend API.

3. --permission-mode
What it does
Controls how often Claude asks for permission before performing actions.
Syntax
    claude --permission-mode default
Possible modes:
| Mode                | Meaning                                                     |
| ------------------- | ----------------------------------------------------------- |
| `default`           | Ask permission for important actions.                       |
| `acceptEdits`       | Automatically accept file edits, but ask for other actions. |
| `plan`              | Claude only creates a plan; it doesn't make changes.        |
| `dontAsk`           | Perform allowed actions without asking repeatedly.          |
| `bypassPermissions` | Skip almost all permission checks (use carefully).          |

4. --append-system-prompt
What it does
Adds extra instructions for Claude only during this session.
Example
claude --append-system-prompt "Always write tests first"
Now Claude remembers throughout the session:
Always generate unit tests before implementation.
Another example:
claude --append-system-prompt "Use Java 21 features"
Every Java example will use Java 21.

5. --dangerously-skip-permissions
What it does
Skips almost all permission prompts.
Example
Instead of:
Claude:
May I modify UserService.java?
Claude immediately edits it.
Start Claude like this:
claude --dangerously-skip-permissions
Why "dangerously"?
Because Claude can:
Edit files
Delete files
Run commands
without asking first.
Useful in trusted environments or automation, but risky if you're not expecting changes.

6. -p
What it does
Runs one prompt, prints the answer, and exits.
No interactive chat starts.
Example
claude -p "Explain this function"
Output:
This function validates user input...
Then Claude exits.
When is it useful?
For scripts.
Instead of:
Open Claude
↓
Type question
↓
Get answer
↓
Exit
You do everything in one command.

7. Pipe (|) content into Claude
What it does
Sends the output of another command directly to Claude.
Example from the slide:
cat error.log | claude -p "What went wrong?"
Breaking it down
cat error.log
↓
Reads the file.
NullPointerException...
↓
|
Passes that text to Claude.
↓
claude -p
Claude receives the log and answers:
The application crashed because UserService returned null.
Another example
Suppose you have a Maven build log.
cat build.log | claude -p "Why did the build fail?"
Claude analyzes the build log and explains the error.


Claude Code can be used in two ways:

Chat Window
    Supports only a limited set of slash commands.
    Bash mode (!) is not supported, so you cannot run terminal commands.
    Suitable for asking coding questions and getting explanations.

Terminal (Claude Code CLI)
    Supports all slash commands.
    Supports Bash mode (!), allowing you to run terminal/shell commands directly.
    Provides the full Claude Code experience.

Key takeaway
    Chat Window → Limited functionality (no ! bash mode, only some slash commands).
    Terminal (CLI) → Full functionality (all slash commands + bash mode).

    To open the Terminal in VsCode you use Ctlr+~




Summary
Instead of manually opening a terminal and running:
claude
every time you want to use Claude Code, you can configure VS Code to automatically open Claude Code in terminal mode whenever you click the Claude Code icon.

Benefits
    Saves time by eliminating the need to manually open the terminal.
    Starts a new Claude Code session with a single click.
    Makes your development workflow faster and more convenient.

Key takeaway: Configure VS Code so that clicking the Claude Code icon automatically launches a terminal with Claude Code, avoiding the need to repeatedly type the claude command.





To open settings in VsCode Ctrl+,
1. Allow Dangerously Skip Permissions
    What it does:
        Claude will not ask for permission before reading, editing files, or running commands.
    Use when:
        Only in a safe sandbox or test environment.
    Recommended?
        ❌ No for normal development.

2. Autosave
    What it does:
        Automatically saves your files before Claude reads or modifies them.
    Benefit:
        You don't lose unsaved changes.
    Recommended?
        ✅ Yes (keep enabled)

3. Claude Process Wrapper
    What it does:
        Lets you specify a custom executable to launch Claude.
    Who needs it?
        Advanced users only.
    Most users:
        Ignore it.

4. Disable Login Prompt
    What it does:
        Stops Claude from asking you to log in.
    Use when:
        Authentication is handled externally (company setup).
    Most users:
        Leave it OFF.

5. Enable New Conversation Shortcut
    What it does:
        Allows
        Ctrl + N
        to start a new Claude conversation.
    Benefit
        Quick keyboard shortcut.

6. Enable Reopen Closed Session Shortcut
    What it does:
        Allows
        Ctrl + Shift + T
        to reopen the last closed Claude session.
    Benefit
        Recover a conversation you closed accidentally.

7. Environment Variables
    What it does
        Passes environment variables (like API keys) to Claude.
    Example:
        ANTHROPIC_API_KEY
    Most beginners
        Don't touch this.

8. Hide Onboarding
    What it does
        Hides the welcome/tutorial screen.
    Use when
        You've already learned Claude Code.

9. Initial Permission Mode
    What it does
        Controls how Claude asks for permissions when a new session starts.
    Examples:
        Ask every time
        Default
        More automatic
    Recommended
        Leave as Default.

10. Preferred Location
    What it does
        Decides where Claude opens inside VS Code.
    Examples:
        Panel
        Sidebar
        Editor
    Recommended
        Panel (default).

11. Respect Git Ignore
    What it does
        Claude ignores files listed in
        .gitignore
    Example:
        node_modules/
        target/
        build/
        Claude won't search those folders.
    Recommended
        ✅ Yes

12. Use Ctrl+Enter To Send
OFF
Enter
sends the message.
ON
Ctrl + Enter
sends the message.
Enter
creates a new line.
Useful if you write long prompts.

13. Use Python Environment
What it does
If your project uses Python virtual environments,
Claude activates it automatically.
Example
venv
or
conda
Java developers
Usually not needed.

14. Use Terminal
    What it does
        When enabled, clicking Claude opens the terminal version instead of the VS Code chat UI.
    Instead of
        VS Code Chat
        it opens
        Terminal
        ┌──────────────────────────┐
        │ Claude Code              │
        │ ❯                        │
        └──────────────────────────┘
    Recommended if
        You prefer the full Claude Code CLI experience.

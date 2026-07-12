Three Ways to Communicate with Claude Code
1. CLI Commands (Before starting a session)
These are commands you run in the terminal before Claude Code starts.
| Command                            | Purpose                                                                                  |
| ---------------------------------- | ---------------------------------------------------------------------------------------- |
| `claude`                           | Starts a new interactive Claude Code session.                                            |
| `claude "Fix the login bug"`       | Starts a session and immediately begins working on the given prompt.                     |
| `claude -p "Explain this project"` | Runs a **single query**, prints the answer, and **exits automatically** (headless mode). |
| `claude --model opus`              | Starts Claude Code using a specific AI model (e.g., Opus or Sonnet).                     |
| `claude -c`                        | Continues your **last Claude Code session**.                                             |

1. claude
What it does:
Starts a new interactive Claude Code session. Claude remains active, allowing you to ask multiple questions, explore the codebase, edit files, and perform development tasks.
When to use:
Use this when you plan to spend time working on a project, such as understanding the codebase, debugging issues, implementing features, or refactoring code.
Example:
claude

2. claude "Fix the login bug"
What it does:
Starts Claude Code and immediately passes your prompt as the first task. Claude begins working on it as soon as the session starts, and the session remains open for follow-up questions.
When to use:
Use this when you already know what you want Claude to do first and don't want to type the prompt after the session starts.
Examples:
claude "Explain this project"
claude "Add unit tests for UserService"
claude "Fix the login bug"

3. claude -p "Explain this project"
What it does:
Executes a single prompt, prints the response to the terminal, and exits immediately. No interactive session is created. This is known as headless mode.
When to use:
Use this for quick one-time questions or when integrating Claude Code into shell scripts, CI/CD pipelines, or automation workflows.
Example:
claude -p "Summarize pom.xml"

4. claude --model opus
What it does:
Starts Claude Code using a specific AI model, such as Opus or Sonnet.
When to use:
Opus: Best for complex reasoning, architecture discussions, large-scale refactoring, and difficult debugging.
Sonnet: Faster and suitable for everyday coding tasks, explanations, and code generation.
Example:
claude --model opus

5. claude -c
What it does:
Reopens your most recent Claude Code session, including its conversation history and context, so you can continue from where you left off.
When to use:
Use this when you've closed Claude Code (for example, at the end of the day) and want to continue the same discussion or development work without re-explaining the project.
Example:
claude -c

Quick Recap
claude              → Start a new interactive session.
claude "prompt"     → Start a new session and immediately begin working on the given task.
claude -p "prompt"  → Ask one question, get the answer, and exit (headless mode).
claude --model opus → Start Claude Code with a specific AI model.
claude -c           → Resume your previous Claude Code session.




2. Slash Commands (During a session)
These commands are typed inside an active Claude Code session.
Examples:
/login – Log in to Claude.
/init – Create a CLAUDE.md file with project instructions.
/help – Show available commands.

Slash Commands (Short Summary)
Slash commands are commands that start with a forward slash (/).
They can only be used inside an active Claude Code session.
They perform specific actions instead of asking coding questions.
Common examples:
    /login – Log in to Claude.
    /logout – Log out of Claude.
    /exit – Exit the current session.
Key points:
    Claude Code supports many built-in slash commands.
    You can also create custom slash commands to automate repetitive tasks or workflows.




3. Special Notations
These are shortcuts that make chatting with Claude Code faster and easier (e.g., special symbols or references).
| **Notation**   | **What it does**                                                                   |
| -------------- | ---------------------------------------------------------------------------------- |
| `@src/main.py` | References a specific file. Claude reads that file instantly.                      |
| `!git status`  | Runs a shell/terminal command directly without Claude's conversational processing. |
| `#`            | Adds a quick note or context to Claude's memory for the current session.           |

Special notations are symbols that help you interact with Claude Code faster.
1. @ – Reference a file
Use @ to point Claude directly to a specific file.
Why use it?
Claude immediately opens that file instead of searching the project.
Saves time and gives more accurate answers.
Example:
Explain what @src/main.py does.

2. ! – Run a terminal command
Use ! to execute a shell/terminal command directly from the Claude Code session.
Why use it?
Quickly run commands without leaving Claude Code.
Example:
!git status

3. # – Add session context
Use # to give Claude an instruction or note that it should remember for the current session.
Why use it?
Provide extra context or preferences without repeating them.
Example:
# We are using Java 21 in this project.

Quick Recap
@ → Point Claude to a specific file.
! → Run a terminal command.
# → Add temporary instructions/context for the current session.




> /
/claude-api     Build, debug, and optimize Claude API / Anthropic SDK apps.
                Apps built with this include prompt caching.
                Also handles migrating existing Claude API code.

 /add-dir       Add a new working directory
 /advisor       Configure the Advisor Tool to consult a stronger model for guidance at key moments
...
The built-in slash commands list that appears when you type / inside a Claude Code session.

This is what happened when you exited the Claude Code session.
/exit
The /exit slash command closes the current Claude Code session and returns you to your terminal.

Resume this session with:
claude --resume 61af8d39-bef2-4156-a14b-fa5adb27c8ba
Resume this session
Claude also displayed:
claude --resume 61af8d39-bef2-4156-a14b-fa5adb27c8ba
This means your session was saved. Running the above command will reopen that exact session, preserving its conversation history and context.
You can also use:
claude -c
to resume your most recent session without specifying the session ID.




Side Note: 
PS D:\AI\claude-code-udemy-eazy-bytes\Section-1\Chapter-4\java-faker> claude -p explain me about this project ⚠ claude.ai connectors are disabled because ANTHROPIC_API_KEY or another auth source is set and takes precedence over your claude.ai login · Unset it to load your organization's connectors
Meaning:It means Claude Code detected that you're authenticating using an API key (or another authentication method) instead of your Claude.ai account.
From your warning:
ANTHROPIC_API_KEY or another auth source is set and takes precedence over your claude.ai login this suggests Claude Code is preferring an API key over your Claude.ai login.
If you are using an ANTHROPIC_API_KEY
    ✅ Every request is billed against your Anthropic API account.
    ✅ You consume API tokens (input + output tokens).
    ❌ It does not use your Claude Pro subscription quota.
If you are using your Claude Pro login (without an API key)
    ✅ Requests use your Claude Pro subscription.
    ❌ You are not billed per API token.




S D:\AI\claude-code-udemy-eazy-bytes\Section-1\Chapter-4> claude -p explain me the overall project java-faker structure/purpose
Output:
"
This directory (`Section-1/Chapter-4`) is a course exercise about using Claude Code to understand an unfamiliar project — the README documents the exact walkthrough (clone `java-faker`, open it with `claude`, run `/login`, ask "explain this project"). Here's that explanation of the `java-faker` project itself:

**What it is:** `java-faker` (`com.github.javafaker`, Maven artifact `javafaker`) is a Java port of Ruby's `faker` gem — a library for generating realistic-looking fake data for tests, demos, and development seeding.
...
"




WHat is difference between asking claude with logged in session and without logged in session 
───────────────────────────────── 
explain me about this project
─────────────────────────────────
and 
S D:\AI\claude-code-udemy-eazy-bytes\Section-1\Chapter-4> claude -p explain me the overall project java-faker structure/purpose

The main difference is not the quality of the answer, but how Claude Code runs and whether the conversation continues.
1. Interactive Session (Logged-in or Active Session)
Example:
❯ explain me about this project
or
claude 
then inside Claude:
❯ explain me about this project

How it works
    Claude starts an interactive chat.
    It remembers everything you asked earlier.
    You can ask follow-up questions.
    It can edit files, run commands, and ask for permissions.
    The session stays open until you exit.

Example
You: Explain this project.
Claude: Explains the project.
You: Which package handles authentication?
Claude: Answers based on the previous explanation.
You: Add JUnit tests for it.
Claude: Starts writing tests.
This is like having a continuous conversation with a senior developer.

2. One-shot Mode (claude -p)
Example:
claude -p "Explain me the overall java-faker project structure and purpose"
How it works
    Claude receives only one prompt.
    It analyzes the project.
    Prints the answer.
    Immediately exits.
There is no conversation.
If you have another question:
    claude -p "Explain src/main/java"
Claude starts from scratch again.

Which should you use?
Use claude when:
    Learning a new project.
    Debugging.
    Refactoring.
    Writing code.
    Asking many follow-up questions.
Use claude -p when:
    You need a quick answer.
    You're scripting or automating.
    You don't need a conversation.




PS D:\AI\claude-code-udemy-eazy-bytes\Section-1\Chapter-4\java-faker> claude --model opus
──────────────────────────────────────────────────────────────────────────────────────────────────────────────
❯ /model
──────────────────────────────────────────────────────────────────────────────────────────────────────────────
ENTER
  Select model
   Switch between Claude models. Your pick becomes the default for new sessions. For other/previous model names, specify with --model.

     1. Default (recommended)  Sonnet 5 · Efficient for routine tasks
     2. Sonnet                 Sonnet 5 · Efficient for routine tasks
     3. Fable                  Fable 5 · Most capable for your hardest and longest-running tasks
   ❯ 4. Opus ✔                 Opus 4.8 · Best for everyday, complex tasks · ~2× usage vs Sonnet
     5. Haiku                  Haiku 4.5 · Fastest for quick answers





+ src/main/java/com/github/javafaker/service/FakeValues.java
+ src/main/java/com/github/javafaker/service/FakeValuesService.java
+ src/main/java/com/github/javafaker/service/FakeValuesGrouping.java
+ src/main/java/com/github/javafaker/service/FakeValuesInterface.java
──────────────────────────────────────────────────────────────────────────────────────────────────────────────
> Explain the code present in @src/main/java/com/github/javafaker/service/FakeValues.java
──────────────────────────────────────────────────────────────────────────────────────────────────────────────
In this example, the @ symbol is being used to reference the file:
@src/main/java/com/github/javafaker/service/FakeValues.java
This tells Claude Code to open and read that specific file before answering the prompt.

Output:
"
This class is part of the Java Faker library. Its job is to represent one locale's data source (a YAML file) and lazily load the fake-data values from it. Here's a walkthrough:
Purpose
FakeValues implements FakeValuesInterface and wraps a single YAML resource file (like en.yml, en-US.yml, de.yml) that contains all the fake data (names, addresses, etc.) for a given Locale.
...
"

Now if I press enter, behind the scenes, the Claude Code, it is going to read all the content inside the source file. And after few seconds, it is going to give me the details about the source code present 
inside the file. If I don't use this @ symbol, then the Claude Code is going to search for that file manually 
by using grep search commands. And that is going to take more amount of time. And in fact, it is also going to attract more bill as well.




Using ! (Bash Mode) in Claude Code
──────────────────────────────────────────────────────────────────────────────────────────────────────────────
❯ what is the current working directory name ?
──────────────────────────────────────────────────────────────────────────────────────────────────────────────
The current working directory name is java-faker.
Full path: D:\AI\claude-code-udemy-eazy-bytes\Section-1\Chapter-4\java-faker
✻ Baked for 2s
──────────────────────────────────────────────────────────────────────────────────────────────────────────────
! pwd
──────────────────────────────────────────────────────────────────────────────────────────────────────────────
/d/AI/claude-code-udemy-eazy-bytes/Section-1/Chapter-4/java-faker
That confirms it — the current working directory is /d/AI/claude-code-udemy-eazy-bytes/Section-1/Chapter-4/java-faker, so the directory name is java-faker.
The ! symbol lets you run terminal (bash/shell) commands directly inside Claude Code instead of asking Claude to answer them.
Why use !?
    Stay in Claude Code – No need to open another terminal.
    Faster – Simple tasks can be done instantly using terminal commands.
    Save AI usage – No need to ask Claude for information that a shell command can provide, which can reduce unnecessary AI requests.
Key takeaway
    Without ! → Claude thinks and answers your question.
    With ! → The terminal executes the command and shows the result directly.





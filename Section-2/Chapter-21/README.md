Simplified Explanation: What is a Session in Claude Code?
Think of a session like one notebook for one conversation.
Every time you open Claude Code and start chatting, Claude creates a new notebook (session).

What does Claude save in a session?
Inside that notebook, Claude stores:
    📝 Every message you type.
    🛠️ Every tool it uses.
    📋 Every result it generates.
    📂 A copy (snapshot) of files before changing them, so changes can be undone.
Important: This information stays only in that session.

What happens when you start a new session?
A new session is like opening a brand-new notebook.
Claude does not remember what you discussed in yesterday's session.
It starts with a fresh context window.

Then how does Claude remember things across sessions?
There are 2 ways.
1. Auto Memory
Claude automatically remembers important long-term information, such as:
- Your coding preferences
- Project patterns
- Frequently used practices
- Important learnings
It saves only the important details, not every conversation.
Example:
If you always use Python 3.12 and prefer pytest, Claude may remember that.

2. CLAUDE.md
CLAUDE.md is a file that contains permanent instructions for your project.
Whenever you start a new session, Claude reads this file automatically.
You can store things like:
Coding standards / Library versions / Project structure / Best practices / Naming conventions / Rules for writing code
Example:
- Use Java 21
- Use Spring Boot 3
- Always write unit tests
- Follow Clean Architecture
Now every new session already knows these rules.

Don't make CLAUDE.md too large
Although you can write around 500–600 lines, you shouldn't fill it with everything.
Why?
Because Claude has a limited context window.
If CLAUDE.md is very long:
 - More context is used to read instructions. 
 - Less space remains for your actual coding task.
So keep only the important and permanent rules in CLAUDE.md.

Easy Analogy
Imagine Claude is a student.
📒 Session = One notebook for today's class.
🧠 Auto Memory = Things the student remembers from experience.
📖 CLAUDE.md = A rule book the student reads before every class.
Every new class starts with a new notebook, but the student can still use their memory and rule book.

Summary
| Concept           | Simple Meaning                                                 |
| ----------------- | -------------------------------------------------------------- |
| **Session**       | One conversation stored in a notebook                          |
| **New Session**   | Starts with a fresh notebook and fresh context                 |
| **Auto Memory**   | Claude remembers important long-term information automatically |
| **CLAUDE.md**     | A permanent project instruction file loaded in every session   |
| **Best Practice** | Keep `CLAUDE.md` short and include only permanent rules        |

===========

Simplified Explanation: Naming and Resuming Sessions in Claude Code
Imagine each Claude session is like a notebook.
When you stop working, Claude saves that notebook. 
Later, you can open the same notebook and continue where you left off.

1. Naming a Session
    By default
    When you exit a session, Claude gives it a random name (Session ID), such as: abc123xyz
    This ID isn't meaningful, so if you have many sessions, it's difficult to remember which one was for which project.

    Solution: Rename the session
    While you're inside an active session, run: /rename refactor-auth-system
    Now the session has a meaningful name.
    Instead of seeing: abc123xyz
    you'll see: refactor-auth-system
    This makes it much easier to find later.
    Note: You can rename only after the session has started. You cannot name a session when creating it.

2. Viewing Old Sessions
    Run: /resume
    Claude will show all your saved sessions, including:
    - Session name
    - Session ID
    - Summary
    - Timestamp
    You simply choose the one you want to continue.

3. Continue the Most Recent Session
    If you accidentally close your terminal or restart your computer, you don't need to start over.
    Just run: claude --continue
    or the short version: claude -c
    This opens your most recent session.
    Think of it as reopening the notebook you were just using.

4. Resume a Specific Session
    Suppose you worked on two projects:
    Login System + Payment Gateway
    Now you want to continue the Login System session.
    Use: claude --resume <session-id>
    Example:
    claude --resume abc123xyz
    Claude opens that exact session.

5. What Happens When You Resume?
    When a session is resumed:
    ✅ Your complete conversation history returns.
    ✅ Claude remembers everything from that session.
    ✅ Any new messages continue in the same session.
    ❌ However, permissions reset.
    If Claude previously had permission to edit files or run commands, you'll need to approve those permissions again.


Summary
| Command                            | Purpose                                    |
| ---------------------------------- | ------------------------------------------ |
| `/rename <name>`                   | Give the current session a meaningful name |
| `/resume`                          | Show all saved sessions and choose one     |
| `claude -c` or `claude --continue` | Continue the most recent session           |
| `claude --resume <session-id>`     | Resume a specific old session              |

In one sentence:
Rename sessions so they're easy to identify, and use claude -c or claude --resume to continue working from exactly where you left off.

=====================

Simplified Explanation: Forking a Session in Claude Code
Imagine you've been working in a session and everything is going well.
Now you want to try a completely different approach, but you don't want to risk changing or ruining your current session.
That's when you use Fork Session.

What is a Fork?
A fork creates a new session by copying everything from your current session.
The new session starts with:
    ✅ All previous conversations
    ✅ All context
    ✅ All progress made so far
But after that, it becomes independent.
Anything you do in the new session does not affect the original session.

Command
    claude --continue --fork-session
This command:
    Continues from your latest session.
    Creates a new copy of it.
    Lets you experiment freely.

Example
Suppose you're building a login system.
Current session:
    Login feature completed
    ↓
    User authentication completed
    ↓
    JWT authentication added

Now you're thinking:
    "What if I use OAuth instead of JWT?"
Instead of changing your current session, you fork it.
Now you have:
Original Session
    Uses JWT
Forked Session
    Try OAuth
    Experiment freely
Both sessions exist separately.

Permissions
Just like a resumed session, a forked session does not keep previous permissions.
If Claude needs permission to edit files or run commands, you must approve them again.

Summary
| Feature                            | What it does                                     |
| ---------------------------------- | ------------------------------------------------ |
| `claude --continue --fork-session` | Creates a new session by copying the current one |
| Conversation history               | ✅ Copied                                         |
| Original session                   | ✅ Remains unchanged                              |
| New session                        | ✅ Can go in a different direction                |
| Previous permissions               | ❌ Not copied (must approve again)                |

In one sentence:
Forking a session is like making a photocopy of your work
keep the original safe while experimenting freely in the copy.

Opening the Same Session in Two Terminals (Short Summary)
- You can open the same Claude session in two terminals, but it's not recommended.
- Both terminals write to the same session, so messages get mixed together.
- Nothing gets corrupted, but the conversation becomes confusing.
- During the session, each terminal only shows its own messages, but later, when you resume, you'll see all messages interleaved.

Best Practice
✅ Use claude --continue --fork-session for the second terminal.
This creates a separate copy of the session, so both terminals can work independently without interfering with each other.


Resume vs Fork (Short Summary)
| **Resume**                                     | **Fork**                                 |
| ---------------------------------------------- | ---------------------------------------- |
| Uses the **same Session ID**                   | Creates a **new Session ID**             |
| Continues from where you stopped               | Copies history, then starts a new branch |
| New messages are added to the original session | Original session remains unchanged       |
| Use when continuing the same task              | Use when trying a different approach     |
| Requires permission approval again             | Requires permission approval again       |

Diagram Explanation
Imagine your original session is a straight line.
Resume / Continue
=================
You keep writing in the same notebook.
Original Session (Session ID: x179a)
●──●──●──●──●──●──●──●
             ↑
       Resume / Continue
             │
      Continue writing here
      (Same Session ID)
- Session ID stays the same.
- Conversation continues from where you left off.
- New messages are added to the same session.

Fork
====
You make a copy of the notebook and start writing in the copy.
Original Session (Session ID: x179a)
●──●──●──●──●──●──●──●
         │
         │ Fork
         ▼
         ●──●──●──●
      New Session (Session ID: k342f)
- A new Session ID is created.
- Previous conversation is copied.
- Original session remains unchanged.
- Both sessions can now continue independently.

Easy Way to Remember
Resume = Continue the same notebook.
Fork   = Photocopy the notebook and experiment in the copy.


Simplified Explanation: Claude Code Sessions Across Git Branches
A common question is: "If I switch to another Git branch, will Claude start a new session?"
Answer: No.
Claude Code does not create a new session when you switch Git branches.

How Claude decides a session
Claude links a session to your project folder (directory), not to:
❌ Git branch
❌ File name
It only cares about which folder you're working in.

Example
Suppose your project folder is:
MyProject/
Inside this folder, you have two Git branches:
Branch feature-login
    MyProject/
    └── index.html
Branch feature-home
    MyProject/
    └── home.html
When you switch from feature-login to feature-home:
- The files in the folder change.
- But Claude stays in the same conversation (same session).

What Claude remembers
Claude remembers:
✅ Your previous conversation
✅ Instructions you gave
✅ Context of the session
Even after switching branches.

What changes?
Although the conversation stays the same, Claude always reads the current files from the active Git branch.
For example:
Step 1
    You're on Branch A.
    Current file: index.html
    Claude reads index.html.
Step 2
    You switch to Branch B.
    Current file: home.html
    Now Claude reads home.html.
The conversation history is still the same, but Claude now works with the files from Branch B.

Simple Diagram
Project Folder (Same Directory)
│
├── Branch A
│     index.html
│
│  Switch Branch
│        ↓
│
├── Branch B
│     home.html
│
└── Claude Session
      ↑
      Same conversation
      Same session
      Reads whichever branch is currently active

Key Points
📂 Claude sessions are tied to the project folder, not the Git branch.
🔄 Switching Git branches does not create a new session.
💬 Your conversation history remains the same.
📄 Claude automatically reads the files from the currently active branch.

Note: The lecture also mentions Git Worktrees for using multiple independent Claude sessions in parallel, but that topic is covered later, so you don't need to worry about it now.



Smart Developer's Session Habits (Simplified with Examples)
These are 5 good habits that help you use Claude Code efficiently.
1. Clear Between Different Tasks
    What it means
    When you finish one task (like fixing a bug) and start a completely different task (like adding a new feature), run:
    /clear
    This removes the old conversation from Claude's context.
    Why?
    Otherwise, Claude may keep thinking about the previous task, which wastes context window.
    Example
    ❌ Without /clear
        Task 1: Fix login bug
        ↓
        Now start Payment Gateway feature
        Claude still remembers lots of login bug discussion.
    ✅ With /clear
        Finish Login Bug
        ↓
        /clear
        ↓
        Start Payment Gateway feature
    Now Claude focuses only on the new feature.

2. Compact at Natural Breakpoints
    What it means
    Don't wait until the context window is almost full (80–85%).
    Run: /compact after finishing a small part of the work.
    Example
    Suppose you're building an e-commerce website.
    Step 1 -> User Login ✅ -> Run: /compact
    Step 2 -> Product Catalog ✅ -> Run: /compact
    Step 3 -> Shopping Cart -> Continue working...
        This keeps the context small and efficient.
        You can even tell Claude what to keep.
    Example: /compact Keep only the implementation plan and latest test results.

3. Name Important Sessions
    Use: /rename payment-gateway
    instead of leaving the session with a random ID.
    Example
    Without rename
        abc123
        xyz789
        pqr456
    Hard to remember.

    With rename
        payment-gateway
        login-refactor
        bug-fix-order-api
    Much easier to find later.

4. Monitor Your Context
    Run periodically: /context
    This shows how much of the context window has been used.
    Think of it like...
    A car's fuel gauge.
    Fuel = Context Window
    If you're already using 60% or more and still have a lot of work left: Use /compact
    Or start a fresh session using /clear
    This prevents running out of context later.

5. For Large Tasks, Save Progress to a Markdown File
This is useful for projects that may take many hours or days.
Step 1
    Ask Claude: "Write the project plan and current progress into progress.md."
    Example: progress.md
    ✓ Login completed
    ✓ Database created
    ✓ JWT implemented
    Next:
    - Payment API
    - Email Notification
Step 2
    Run /clear . This gives Claude a fresh context.
Step 3
    Start a new session and say: "Read progress.md and continue the project."
    Claude quickly understands where it left off without needing the entire old conversation.

Quick Summary
| Habit               | Command            | Example                                          |
| ------------------- | ------------------ | ------------------------------------------------ |
| Start a new task    | `/clear`           | Finish bug fix → Clear → Start new feature       |
| Save context        | `/compact`         | After completing a module                        |
| Name sessions       | `/rename`          | `payment-gateway`                                |
| Check context usage | `/context`         | If usage > 60%, compact or clear                 |
| Long projects       | Save to `.md` file | Save progress → Clear → Read file in new session |

Easy Analogy
    Imagine you're studying:
    🧹 /clear = Erase the whiteboard before starting a new chapter.
    📚 /compact = Write short notes instead of keeping every detail.
    🏷️ /rename = Put a label on your notebook.
    ⛽ /context = Check the fuel gauge to see how much space is left.
    📄 progress.md = A summary notebook that lets you continue your work later without rereading everything.
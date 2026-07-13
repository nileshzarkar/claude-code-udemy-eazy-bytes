Context Window in Claude Code (Simplified Explanation)
The Context Window is one of the most important concepts to understand when using Claude Code or any AI coding assistant (GitHub Copilot Chat, Cursor, Gemini Code Assist, etc.).
It is not unique to Claude Code—every LLM (Large Language Model) has a context window.

What is a Context Window?
A context window is the AI's working memory during a session.
Think of it as Claude's RAM.
Just like a computer uses RAM to remember the applications currently running, Claude uses the context window to remember everything related to your current session.

Real-Life Analogy: Computer RAM
Imagine your laptop has 16 GB RAM.
You open:
Chrome with 50 tabs → 8 GB
VS Code with a large project → 3 GB
Docker Desktop → 2 GB
Now you've used:
8 + 3 + 2 = 13 GB
Only 3 GB RAM remains.
If you continue opening more applications:
        RAM becomes full.
        Windows starts swapping memory to disk.
        Everything becomes slow.
        Applications may freeze or crash.
    The CPU isn't bad.
    The problem is that the working memory (RAM) is full.
Claude works in a very similar way.

Claude's RAM = Context Window
Instead of RAM, Claude has a Context Window.
Instead of storing applications, it stores:
Your conversation / Files it has read / Commands it has executed / Command outputs / Project instructions / System prompts / Skills
Everything must fit inside this window.

Example
Suppose Claude's model supports a 1,000,000-token context window (the slide uses this as an example).
Claude has 1 million tokens available.
Everything must fit inside those 1 million tokens.

What occupies the Context Window?
The slide mentions these items.
1. System Prompt
    These are Claude's built-in instructions.
    Example:
        You are Claude Code.
        Help the developer.
        Follow security rules.
    These instructions already consume some tokens before you even ask your first question.

2. Conversation History
    Every conversation is remembered.
    Example:
        You:
        Explain Java Streams.
        Claude:
        ...
        You:
        Now optimize this method.
        Claude:
        ...
    Every message remains inside the context window.
    As the conversation grows...
    ...more tokens are consumed.

3. Project File Contents
    Suppose you ask:
        Explain UserService.java
        Claude reads: UserService.java
        That file is added to the context.
        Then you ask: Explain OrderService.java
        Claude reads: OrderService.java
    Now both files are remembered.

4. Command Outputs
    Suppose Claude runs:
        mvn test
        Output:
        200 lines
    Those 200 lines are stored in the context.
    Now Claude knows the test results.

5. CLAUDE.md Instructions
    Many projects have CLAUDE.md
    This file contains instructions like:
        Always use Java 21.
        Use JUnit 5.
        Never modify generated code.
    Claude remembers these instructions.

6. Loaded Skills and System Rules
    Claude may load special skills or built-in rules.
    Examples:
        Git skill
        Java skill
        Security rules
        Refactoring rules
    These also consume tokens.

Example Token Usage
The slide gives this example for a 1,000,000-token context window:
| Item                   | Tokens Used |
| ---------------------- | ----------: |
| System Prompt          |     100,000 |
| Conversation History   |     400,000 |
| Tool Call Results      |      50,000 |
| Skills                 |      50,000 |
| Available for new work |     400,000 |
Notice that before you continue working, 600,000 tokens are already in use, leaving 400,000 tokens available.

What happens while working?
Suppose you ask: Explain UserService.java
Claude reads: 3000 tokens
Context increases. 

Then: Explain OrderService.java
Another 5000 tokens
More tokens.

Then: mvn test
Output:  8000 tokens
More tokens.

Then:  Explain this stack trace
Another: 15000 tokens
More tokens.

As you continue working: 
    Context Window
    □□□□□□□□□□
    ↓
    ■■□□□□□□□□
    ↓
    ■■■■□□□□□□
    ↓
    ■■■■■■□□□□
    ↓
    ■■■■■■■■□□
    ↓
    ■■■■■■■■■■
Eventually it fills up.

What is Context Bloating?
    Context bloating means the context window becomes filled with lots of old information.
    For example:
    150 conversations + 25 Java files + Maven logs + Git diffs + Stack traces + Test outputs + Build logs
    Even if you are no longer using some of this information, it is still taking up space.

Why is Context Bloating Bad?
As the context grows:
1. More tokens to process
Claude has to read more information before answering.
This increases processing time.

2. Responses become slower
Instead of reading: 20,000 tokens
Claude may need to process: 800,000 tokens
That naturally takes longer.

3. Reduced accuracy
Important information can get buried among older, less relevant context.

4. Less room for new information
If most of the context window is already occupied, there is less space for new files, commands, and conversation.

How to check Context Usage?
Claude provides the command: /context
This command shows:
    Total context size
    How much is used
    What is consuming the context
    How much is still available
This helps you understand why the context window is filling up.

Why start a Fresh Session?
    Suppose today you worked on: Authentication + Docker + Kafka + Kubernetes
    Tomorrow you start working on: Payment Gateway
    If you continue using the same Claude session:
    Claude still remembers yesterday's Docker, Kafka, and Kubernetes discussions.
    Those details occupy space even though they're no longer relevant.
    Instead, start a new session:
        Old Session
        Authentication
        Docker
        Kafka
        ↓
        Close Session
        ↓
        New Session
        Payment Gateway only
    A new session gives Claude a fresh, empty context window.

What happens when the Context Window is almost full?
    The instructor mentions that Claude Code performs some activities behind the scenes when the context window approaches its limit.
    While the exact internal mechanisms aren't exposed, Claude may:
    - Manage or compress parts of the conversation.
    - Drop less relevant context.
    - Optimize what is retained.
    Even with these mechanisms, a nearly full context window generally means less room for new work and can affect efficiency.

Best Practices
    ✅ Start a new session for a new task or feature.
    ✅ Avoid using the same session for several days.
    ✅ Use /context occasionally to monitor usage.
    ✅ Keep conversations focused on one topic.

Key Takeaways
| Concept              | Meaning                                                                           |
| -------------------- | --------------------------------------------------------------------------------- |
| **Context Window**   | Claude's working memory (like RAM)                                                |
| **Contents**         | Conversation, project files, command outputs, `CLAUDE.md`, system prompts, skills |
| **Fixed Size**       | Determined by the underlying AI model                                             |
| **Context Bloating** | Too much information accumulates in one session                                   |
| **Problems**         | Slower responses, reduced efficiency, less room for new information               |
| **Check Usage**      | Use the `/context` command                                                        |
| **Best Practice**    | Start fresh sessions for new or unrelated tasks                                   |

Memory Trick
    Think of the Context Window as Claude's desk:
    1. At the start of a session, the desk is mostly empty.
    2. As you work, you place files, notes, logs, and instructions on the desk.
    3. If you keep adding papers without clearing them, the desk becomes cluttered.
    4. Eventually, it's harder and slower to find what you need.
    A new Claude session is like clearing the desk and starting with a clean workspace.

==================

What Happens When the Context Window Fills Up? (Simplified)

Imagine Claude's context window is like a backpack.
- At the beginning of a session, the backpack is almost empty.
- As you chat, Claude keeps putting things into the backpack:
    Your conversations + Files it reads + Command outputs + Code snippets + Instructions from CLAUDE.md + Tool results
Eventually, the backpack becomes full.
Claude cannot make the backpack bigger because every AI model has a fixed context window.
So Claude needs to make space.

Step 1: Claude Automatically Manages Space
    When the context window starts getting full, Claude automatically tries to free up space.
    It does this without asking you.

Step 2: Remove Old Tool Outputs
    The first thing Claude removes is old tool outputs.
    Example
    Suppose Claude ran: mvn test
    Output: 500 lines of test results
    Later it ran: git diff
    Output: 300 lines
    These outputs consume many tokens.
    If Claude no longer needs them, it removes them first.
    This creates free space while keeping more important information.

Step 3: Compact the Conversation
If removing tool outputs is still not enough, Claude performs a process called Compaction.
Compaction means:  Instead of remembering every detail, Claude creates a short summary.
Think of it like summarizing a long meeting.
Before Compaction
Suppose your conversation contains:
    Message 1
    Message 2
    Message 3
    ...
    Message 200
Very long.

After Compaction
Claude may replace all of that with:
    Summary
    • User is building a Quarkus microservice.
    • Java 21 is used.
    • Authentication module completed.
    • Payment module is pending.
Instead of remembering every message, Claude remembers the summary.

What Does Claude Usually Keep?
Claude tries to preserve the most important things.
    For example:
        ✅ Your requests
        ✅ Important code snippets
        ✅ Recent work
        ✅ Important decisions

What May Be Lost?
Less important or older information may be shortened or removed.
        Examples:
        Old conversations + Old explanations + Very detailed instructions + Older tool outputs

Why is Compaction Needed?
    Because the context window has a fixed size.
    Example:
        Context Window
        □□□□□□□□□□□□□□□□□□
        ↓
        You keep working
        ■■□□□□□□□□□□□□□□
        ↓
        ■■■■■■□□□□□□□□
        ↓
        ■■■■■■■■■■■■□□
        ↓
        Almost Full
        ■■■■■■■■■■■■■■■■
    Claude must free space.
    Otherwise, it cannot continue.

Does Compaction Happen Automatically?
    Yes.
    Whenever the context window reaches a certain level, Claude automatically starts compacting.
    You don't have to do anything.

Is Compaction Perfect?
    No.
    Every time Claude summarizes information, some details are lost.
    Think of a school lesson.
    Original notes: 10 pages
    Summary: 1 page
You still understand the topic.
But some details disappear.
Claude behaves the same way.

What Happens If Compaction Happens Many Times?
Suppose a session lasts for several days.
    Claude compacts:
    Original
    ↓
    Summary 1
    ↓
    Summary 2
    ↓
    Summary 3
    ↓
    Summary 4
Every summary loses a little information.
Eventually Claude may forget important details.

Problems Caused by Too Much Compaction
    The instructor mentions several problems.
    1. Claude may forget your initial instructions.
    Example:
    At the beginning you said: Always generate Java 21 code.
    After many compactions, Claude may forget this instruction.

    2. Claude may forget earlier code changes.
    Suppose Claude modified: UserService.java
    Three hours ago. Later it may forget exactly what changes were made.

    3. Claude may forget files it previously read.
    Earlier it analyzed: CustomerService.java + OrderService.java
    Later those details may disappear.

    4. Claude may forget coding patterns.
    Suppose early in the session it followed:
    Builder Pattern + Repository Pattern + Company naming convention
    After several compactions, Claude may stop following them consistently because the detailed context has been summarized away.

Best Practice
Don't keep using the same session forever.
    Instead:
        Task 1
        ↓
        New Session
        ↓
        Task 2
        ↓
        New Session
        ↓
        Task 3
This gives Claude a fresh context window every time.

Manual Compaction
You can also start compaction yourself.
Command: /compact
Claude immediately summarizes the conversation and frees context space.

Give Instructions During Compaction
You can tell Claude what is important before it compacts.
Example:  /compact "Make sure to retain security related instructions."
Meaning: "When you summarize the conversation, don't lose anything related to security."
Claude gives extra importance to that information while creating the summary.

Using CLAUDE.md
You can also place compaction instructions inside: CLAUDE.md 
    Example:
    # Compact Instructions
    Always retain:
    - Security rules
    - Coding standards
    - Architecture decisions
Whenever Claude compacts the conversation, it will read these instructions and try to preserve those topics.

Why Use CLAUDE.md?
    Don't rely only on chat history for important instructions.
    Imagine you tell Claude once: Always use Java 21.
    If the session becomes very long and is compacted several times, that instruction could eventually be shortened or lost.
    Instead, put it in: CLAUDE.md
    Claude reloads CLAUDE.md as part of the project context, so those rules remain available across compactions and even in new sessions.

What Should Go into CLAUDE.md?
The instructor recommends putting long-term project rules there.
Examples:
Coding Standards
    Always use Java 21.
    Always use JUnit 5.

Folder Structure
    Controllers → Service → Repository

Naming Conventions
    Service classes end with Service.
    DTO classes end with DTO.

Architecture Decisions
    Use REST APIs.
    Use Kafka for asynchronous communication.
    Use PostgreSQL.

These are stable project rules that shouldn't depend on the current chat history.

Complete Flow
    Start Session
    ↓
    Context starts filling
    ↓
    Old tool outputs removed
    ↓
    Still full?
    ↓
    Yes
    ↓
    Automatic Compaction
    ↓
    Conversation summarized
    ↓
    Important information retained
    ↓
    Older details removed
    ↓
    Continue working

Key Takeaways
| Concept                    | Meaning                                                                                                   |
| -------------------------- | --------------------------------------------------------------------------------------------------------- |
| **Context Window Full**    | Claude's working memory is almost full.                                                                   |
| **First Action**           | Remove old tool outputs.                                                                                  |
| **If More Space Needed**   | Automatically compact (summarize) the conversation.                                                       |
| **Compaction**             | Replace detailed history with a shorter summary.                                                          |
| **Usually Kept**           | Recent requests, important code, key decisions.                                                           |
| **May Be Lost**            | Old details, lengthy instructions, old tool outputs.                                                      |
| **Too Many Compactions**   | Claude can gradually forget earlier context and behave less consistently.                                 |
| **Manual Command**         | `/compact`                                                                                                |
| **Guide Compaction**       | `/compact "retain security instructions"`                                                                 |
| **Store Permanent Rules**  | `CLAUDE.md`                                                                                               |
| **Examples for CLAUDE.md** | Coding standards, folder structure, naming conventions, architecture decisions.                           |
| **Best Practice**          | Use a fresh Claude session for each major task or feature rather than keeping one session alive for days. |

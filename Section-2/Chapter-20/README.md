
PS D:\AI\claude-code-udemy-eazy-bytes\Section-2\Chapter-20\hello-world-static-quarkus> 

Prompt:
"
I want to build a simple Quarkus application in Java. Please create a complete, working project with the following requirements:

Endpoint: Create a REST endpoint at /hello using JAX-RS (Quarkus RESTEasy Reactive or classic RESTEasy — your choice, but tell me which).
Java Class: The endpoint should be handled by a Java class (e.g., HelloResource.java) annotated with @Path("/hello") and a @GET method.
Response: Instead of returning plain text or JSON, the endpoint should return a full HTML page (text/html media type) containing a "Hello World" message styled to look fancy — e.g., large centered text, a gradient background, a nice font (Google Fonts or a web-safe fallback), and maybe a subtle animation or shadow effect.
Project structure: Include the necessary Maven pom.xml (or Gradle build file) with Quarkus dependencies (quarkus-resteasy or quarkus-resteasy-reactive), the main resource class, and any HTML/CSS you embed or reference.
Instructions: Explain how to run the app locally using ./mvnw quarkus:dev (or the Gradle equivalent) and confirm the URL (e.g., http://localhost:8080/hello) where I can see the fancy Hello World page.

Please generate all necessary files and code, and briefly explain the structure of the project so I understand how the pieces fit together.
"


PS D:\AI\claude-code-udemy-eazy-bytes\Section-2\Chapter-20\hello-world-static-quarkus> claude
  /model                        Set the AI model for Claude Code (currently Opus 4.8)
──────────────────────────────────────────────────────────────────────────────────────
❯ /model
──────────────────────────────────────────────────────────────────────────────────────

At any point of time inside a Claude session, if you want to understand how much of your context
window is occupied, you can run the command context. So this is going to show you an output something like this.
──────────────────────────────────────────────────────────────────────────────────────
❯ /context
──────────────────────────────────────────────────────────────────────────────────────
 
     Opus 4.8
     claude-opus-4-8
     20k/1m tokens (2%)
     So in brand new session 2% is already consumed. 

 Estimated usage by category
     System prompt: 2.8k tokens (0.3%)
     System tools: 14.3k tokens (1.4%)
     Memory files: 1k tokens (0.1%)
     Skills: 1.9k tokens (0.2%)
     Messages: 8 tokens (0.0%)
     Free space: 980k (98.0%)


==============


The /clear command in Claude Code is used to start a fresh conversation while staying in the same Claude Code session.
Think of it like clearing a whiteboard before starting a new discussion.

What does /clear do?
When you type:  /clear
Claude:
✅ Clears the current conversation history.
✅ Starts a new chat.
✅ Gives you a fresh context window.
✅ Frees up context that was occupied by previous conversations.

Simple Example
Suppose you've been working on Project A.
Conversation: 
    You: Explain UserService.java.
    Claude: ...
    You: Fix the authentication bug.
    Claude: ...
    You: Add unit tests.
    Claude: ...
After an hour, you now want to work on Project B.
Instead of carrying all the old conversation:
    Authentication
    ↓
    UserService
    ↓
    JWT
    ↓
    Unit Tests
    ↓
    Docker

you type: /clear
Now Claude forgets the conversation and starts with an empty chat.

Why use /clear?
Suppose your conversation has become very long.
Instead of:
    100 questions
    50 files
    20 command outputs
you start fresh.

Benefits:
    - Faster responses
    - Less context usage
    - Better focus
    - Lower chance of Claude getting confused

What does /clear NOT remove?
It does not remove project information.
Claude still has access to:
Current project files + CLAUDE.md + Project settings + User settings + Local settings + Managed settings
It only clears the chat history.
Example
Before /clear
    Conversation
    Question 1
    ↓
    Question 2
    ↓
    Question 3
    ↓
    Question 4

After /clear
    Conversation becomes
    (New Conversation)
    You:
    Claude is waiting for your next question.

/clear vs Starting a New Session
They are similar but not exactly the same.
| `/clear`                                   | New Claude Session              |
| ------------------------------------------ | ------------------------------- |
| Clears conversation                        | Starts a completely new session |
| Keeps you in the same Claude Code instance | Creates a brand-new session     |
| Fast                                       | Complete restart                |
| Good for changing topics                   | Good for long-running work      |

/clear vs /compact
This is where people often get confused.
/compact
        Long conversation
        ↓
        Summary
    Claude keeps the important information by summarizing it.
    Nothing is completely forgotten.

/clear
    Long conversation
    ↓
    Deleted
    Claude starts with an empty conversation.
    No summary is retained.

Comparison
| Command    | What it does                                     | When to use                                                                 |
| ---------- | ------------------------------------------------ | --------------------------------------------------------------------------- |
| `/compact` | Summarizes the conversation to save context      | You want Claude to remember the important parts but reduce context usage.   |
| `/clear`   | Removes the conversation and starts a fresh chat | You're switching to a new task or no longer need the previous conversation. |

Real-life Example
Imagine you're working on two unrelated tasks.
Task 1
    Fix Kafka consumer
    ↓
    Debug Docker
    ↓
    Update Kubernetes YAML
    Done.

Now you need to work on:
Task 2
    Create Payment API
    Instead of keeping all the Kafka and Docker discussions in memory, run:
    /clear
    Now Claude focuses only on the Payment API.

Best Practice
Use /clear when:
✅ You've finished one feature and are starting another.
✅ The previous conversation is no longer useful.
✅ You want to free up the context window.
✅ Claude is starting to lose focus because the conversation has become too long.
If you still want Claude to remember the important parts of the current discussion, use /compact instead.

Easy way to remember
/clear   = Erase the whiteboard and start over.
/compact = Rewrite the whiteboard into short notes before continuing.
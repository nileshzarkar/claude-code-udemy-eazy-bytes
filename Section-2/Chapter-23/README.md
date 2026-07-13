Checkpoints in Claude Code (Simplified)
Imagine Claude is making changes to many files at once.
Sometimes those changes are exactly what you want.
But sometimes Claude may make changes you don't like.
How do you go back?
That's where Checkpoints help.

What is a Checkpoint?
A checkpoint is like a save point in a video game.
Before Claude edits your code, it automatically takes a snapshot of your project.
If something goes wrong, you can return to that saved state.

Example
Suppose your project looks like this:
login.js / user.js / config.js
You ask Claude: "Refactor the authentication module."
Claude changes:
✅ login.js + ✅ user.js + ✅ config.js + ✅ Creates new folders
Later, you realize: "I don't like these changes."
Instead of manually fixing everything, you can restore the checkpoint and get your project back to how it was before Claude started editing.

Why not just use Ctrl + Z?
Ctrl + Z works well for small changes.
Example:
Changed one line in app.js
Ctrl + Z
✔ Restored

But Claude may change many files at once.
Example:
Changed:
✓ login.js ✓ user.js ✓ auth.js ✓ config.js ✓ Folder structure
Now questions arise:
Which file changed first?
How many times should I press Ctrl + Z?
Did I accidentally undo something important?
It quickly becomes confusing.

Why Checkpoints are Better
Instead of undoing changes one by one:
Ctrl + Z
Ctrl + Z
Ctrl + Z
Ctrl + Z
...
You simply go back to the saved checkpoint.
Checkpoint
      ↓
Restore
      ↓
Project returns to its previous state

Summary
📸 A checkpoint is an automatic snapshot of your project before Claude edits it.
🛡️ It acts as a safety net.
🔄 If Claude makes unwanted changes, you can restore the checkpoint.
❌ Ctrl + Z is good for small edits but is difficult when Claude changes many files.
✅ Checkpoints make it easy to recover your project with one restore instead of many undos.




How Checkpoints Work in Claude Code (Simplified)
Think of a checkpoint like an automatic save point in a video game.
Every time you ask Claude to modify your code, it first takes a snapshot of your project before making any changes.
You don't have to press Save or create the checkpoint yourself—Claude does it automatically.

How it works
    Your Project
        │
        ▼
    You give a prompt
        │
        ▼
    📸 Claude automatically creates a checkpoint
        │
        ▼
    Claude edits your code
        │
        ▼
    If everything looks good → Continue
    If something goes wrong → Restore the checkpoint

Example 1: Claude Misunderstands Your Request
    Suppose your project contains:
    Project/
    ├── login.js
    ├── user.js
    └── auth.js
    You ask: "Rename one method in login.js."
    Before making any changes:
        📸 Checkpoint created automatically
    Instead of changing one method, Claude accidentally modifies: ✅ login.js ✅ user.js  ✅ auth.js
    You don't like the changes.
    Instead of manually fixing every file, simply restore the checkpoint.
    Your project goes back to exactly how it was before Claude made any changes.

Example 2: Trying a Risky Change
    Suppose your project uses REST APIs.
    You ask Claude: "Convert the entire project to GraphQL."
    Before starting: 
        📸 Checkpoint created.
    After reviewing the result, you decide: "GraphQL isn't a good fit."
    Instead of manually undoing hundreds of changes, restore the checkpoint and you're back to your original REST project.

Example 3: Claude Keeps Making the Same Mistake
    Suppose you're working on authentication.
    Conversation:
    You: Fix the login bug.
    Claude: Fixes it incorrectly.
    You: No, that's not what I meant.
    Claude: Makes another incorrect change.
    You: Still wrong.
    Now the conversation is becoming confusing.
    Instead of continuing to correct Claude:
    Restore the checkpoint taken before the first incorrect change.
    Give a clearer prompt.
This often produces a better result than continuing a long conversation filled with corrections.

Example 4: Requirements Change
    Suppose you're upgrading your project.
    Initial requirement: 
        Upgrade Spring Boot 3 → Spring Boot 4
    Claude starts updating many files.
    Halfway through, your manager says:
        "Don't upgrade to version 4. Upgrade directly to version 5."
    Instead of manually reversing the version 4 changes:
    Restore the checkpoint.
    Start again with:
    "Upgrade directly to Spring Boot 5."
    This saves time and avoids unnecessary changes.


Do Checkpoints Disappear?
No.
Checkpoints are saved even if you:
    Close Claude Code
    Close the terminal
    Start another session
You can restore them later if needed.

Summary
📸 Claude automatically creates a checkpoint before every code edit.
✋ You don't need to create checkpoints manually.
🔄 If Claude makes unwanted changes, you can restore the checkpoint.
💾 Checkpoints remain available even after closing Claude Code.
✅ They are especially useful when:
    Trying risky code changes
    Claude misunderstands your prompt
    The conversation becomes confusing
    Project requirements change midway

In one sentence:
A checkpoint is an automatic backup of your project before Claude edits it, allowing you to safely experiment and instantly return to the previous state if needed.




How to Rewind in Claude Code (Simplified)
A checkpoint is a saved snapshot of your project.
If something goes wrong, you can rewind to a previous checkpoint.
How to open the Rewind menu
There are two ways:
Press Esc twice
Or run: /rewind
Claude will show a list of checkpoints. Select the one you want and choose one of the following options.

1. Restore Code Only
    What it does
        ✅ Restores the code to the selected checkpoint.
        ✅ Keeps the conversation (chat history).
    Use when : The code is wrong, but the conversation is still useful.
    Example
        You ask:
        "Optimize my Java code."
        Claude changes many files, but the optimization is bad.
        However, the conversation contains useful design ideas.
        Choose:
        Restore Code Only
        Result:
        Code  → Back to previous version ✅
        Chat  → Remains unchanged ✅
        You can now ask Claude: "Try a different optimization."

2. Restore Conversation Only
    What it does
        ✅ Restores the conversation.
        ✅ Keeps the current code.
    Use when : The code is correct, but the conversation has gone in the wrong direction.
    Example
        Claude successfully creates a Login API.
        Later you spend 30 minutes discussing an unrelated caching strategy that becomes confusing.
        You like the Login API code, but want to remove the later conversation.
        Choose:
        Restore Conversation Only
        Result:
        Code  → Kept ✅
        Chat  → Goes back to an earlier point ✅
        Now you can give Claude a new prompt without losing the code.

3. Restore Both
    What it does
        ✅ Restores both the code and the conversation.
    Use when : Everything after a certain point should be discarded.
    Example
        You ask Claude:
        "Convert my project to GraphQL."
        Claude changes many files and the discussion continues for several prompts.
        Finally you decide:
        "I don't want GraphQL at all."
        Choose:
        Restore Both
        Result:
        Code  → Restored ✅
        Conversation → Restored ✅
        It is as if the GraphQL experiment never happened.

4. Summarize From Here
    What it does
        This option does not restore anything.
    Instead, Claude:
        Keeps your code unchanged.
        Keeps the important information.
        Compresses (summarizes) the conversation from that checkpoint onward.
        This helps reduce context usage.
    Example
    Suppose your conversation looks like this:
    Checkpoint
    │
    ├── Login discussion
    ├── JWT discussion
    ├── Database discussion
    ├── 100 messages of debugging
    ├── 80 messages of testing
    └── Current work
    Choose:
    Summarize From Here
    Claude replaces those long debugging and testing conversations with a short summary, such as:
    Summary:
    • Login completed
    • JWT fixed
    • Database migrated
    • Tests passed
    The conversation becomes much shorter, freeing up context.

Difference Between /compact and Summarize From Here
| `/compact`                                | Summarize From Here                                     |
| ----------------------------------------- | ------------------------------------------------------- |
| Compresses the entire conversation        | Compresses only from the selected checkpoint onward     |
| Used when the whole chat is getting large | Used when only the recent part is taking too much space |

Quick Summary
| Option                        | Code       | Conversation | When to Use                                          |
| ----------------------------- | ---------- | ------------ | ---------------------------------------------------- |
| **Restore Code Only**         | 🔄 Restore | ✅ Keep       | Code is wrong, discussion is still useful            |
| **Restore Conversation Only** | ✅ Keep     | 🔄 Restore   | Code is good, but you want to restart the discussion |
| **Restore Both**              | 🔄 Restore | 🔄 Restore   | You want to completely go back to an earlier state   |
| **Summarize From Here**       | ✅ Keep     | 📝 Summarize | Reduce context usage without undoing work            |




What Checkpoints Do NOT Track (Summary)
Checkpoints do not save every type of change. They only track files edited using Claude's file editing tools.

❌ Not tracked by checkpoints
Changes made using Bash commands, such as:
    rm file.txt (delete a file)
    mv old.txt new.txt (rename a file)
    cp source.txt dest.txt (copy a file)

If you rewind, these changes will not be undone.

- Manual changes you make outside Claude Code (e.g., editing files in VS Code or another editor) are not captured.
- Checkpoints expire after 30 days, so they are not kept forever.
✅ Tracked by checkpoints
- Files that Claude edits directly using its built-in file editing tools.

Example
Suppose Claude does:
rm config.json
Then you use /rewind.
❌ config.json will NOT come back, because it was deleted using a Bash command, not Claude's file editor.

Key Takeaway
Checkpoints can restore only edits made through Claude's file editing tools. 
They cannot restore changes made via Bash commands or manual edits outside Claude Code.





Why do we need Git Worktrees?
Normally, you work on one branch in one folder.

But sometimes you have multiple tasks at the same time, for example:
🚀 Build a new feature
🐞 Fix a production bug

If you do both in the same folder, you may face:
❌ Mixed changes
❌ File conflicts
❌ Constantly switching branches

What is a Git Worktree?
A Git Worktree lets you create multiple working folders from the same Git repository.
Think of it as having multiple copies of your project, where each copy works on a different branch.
Git Repository
      │
      ├── Worktree 1 → main branch
      ├── Worktree 2 → feature-login branch
      └── Worktree 3 → bugfix-navbar branch
Each worktree:
    📂 Has its own project folder
    🌿 Uses its own Git branch
    🔗 Shares the same Git history and remote repository

Example
Without Worktrees:
    job-portal-ui
        │
    Switch to feature branch
        │
    Switch back to bugfix branch
        │
    Switch again to main
You're constantly changing branches.

With Worktrees:
    job-portal-ui-main
    job-portal-ui-feature
    job-portal-ui-bugfix
You can open all three folders at the same time, each on a different branch.

Why is this useful with Claude Code?
You can run multiple Claude Code sessions simultaneously:
    🤖 Claude Session 1 → Develop a new feature
    🤖 Claude Session 2 → Fix a bug
    🤖 Claude Session 3 → Review or test another branch

Each Claude session works independently without interfering with the others.

Key takeaway
Git Worktrees let you work on multiple branches at the same time by creating separate working folders from the same repository. 
This avoids branch switching, keeps changes isolated, and is ideal for running parallel Claude Code sessions.





How Claude Uses Git Worktrees – Simplified Explanation
When you start Claude Code with the --worktree option, Claude automatically creates a new workspace for a separate task.
Example:
    claude --worktree feature-cache

What happens?
Claude automatically:
    📁 Creates a new project folder (worktree).
    🌿 Creates a new Git branch named feature-cache.
    🤖 Starts Claude Code inside that new workspace.
So you can start working immediately without affecting your main project folder.

Running Multiple Claude Sessions
You can open multiple Claude Code sessions, each working on a different task:
    claude --worktree feature-cache
    claude --worktree bugfix-performance

Now you'll have:
Project Repository
│
├── Worktree 1 → feature-cache
│     └── Claude Session 1
│
└── Worktree 2 → bugfix-performance
      └── Claude Session 2
Session 1: Develop a new cache feature.
Session 2: Fix a performance bug.

Both run at the same time without interfering with each other.

Key takeaway
Using claude --worktree <name> lets Claude automatically create a new folder, a new Git branch, and a new Claude session. 
This allows you to work on multiple independent tasks in parallel without constantly switching branches or mixing changes.






Where Are Worktrees Stored? – Simplified Explanation
When Claude creates a worktree, it stores it inside your project folder:
<your-project>/
│
├── .claude/
│   └── worktrees/
│       ├── feature-cache/
│       └── bugfix-performance/
Each worktree is a separate working folder with its own Git branch.
Claude also follows a branch naming pattern like:
    worktree-feature-cache
    worktree-bugfix-performance

Creating a Worktree During a Claude Session
You don't have to close and restart Claude.
Simply tell Claude:
    "Start a worktree"
    "Work in a worktree"
Claude will automatically:
    📁 Create a new worktree (new folder).
    🌿 Create a new Git branch.
    📂 Move your current task into that new worktree.

You can then continue working without affecting your original project folder.
Example
Suppose you're working in:
job-portal-ui/
You ask:
    Start a worktree for login feature.
Claude creates something like:
job-portal-ui/
│
└── .claude/
    └── worktrees/
        └── login-feature/
and switches your work to the new worktree-login-feature branch automatically.

Key takeaway
Claude can create Git worktrees automatically—either when you start Claude with --worktree or while you're already in a session. 
This gives you a separate folder and branch for each task, keeping your work organized and isolated.

======================

1. Create an Github Issue 
Title: Inside the footer, when hover on "Privacy Policy" nothing being displayed
Description: 
Inside the footer, when hover onto the "Privacy Policy" nothing being displayed. It should display some text regarding Privacy Policy
Add the screen shot as well
https://github.com/nileshzarkar/job-portal-ui/issues/5

2. Create an Github Issue 
Title: Inside the footer, when hover on "Terms of Service" nothing being displayed
Description: 
Inside the footer, when hover onto the "Terms of Service" nothing being displayed. It should display some text regarding Terms Of Service
Add the screen shot as well
https://github.com/nileshzarkar/job-portal-ui/issues/6


Logout from the existing session with:
────────────────────────────────────────────────────────────────────────────────────
> /exit
────────────────────────────────────────────────────────────────────────────────────
claude --resume 089510c6-6e74-491c-9022-915363de740a

3. Open a new terminal window at 
PS D:\AI\job-portal-ui> claude --worktree fix/term-of-service-hover-tooltip
Validate of worktree is created under the .claude folder
D:\AI\job-portal-ui\.claude\worktrees\fix+terms-of-service-hover-tooltip

4. Open a new terminal window at 
PS D:\AI\job-portal-ui> claude --worktree fix/privacy-policy-hover-tooltip
Validate of worktree is created under the .claude folder
D:\AI\job-portal-ui\.claude\worktrees\fix+privacy-policy-hover-tooltip

Now we have 2 claude session running in parallel.

5. This prompt in claude session of worktree 
 D:\AI\job-portal-ui\.claude\worktrees\fix+terms-of-service-hover-tooltip
────────────────────────────────────────────────────────────────────────────────────────
❯ fix the issue https://github.com/nileshzarkar/job-portal-ui/issues/6
────────────────────────────────────────────────────────────────────────────────────────
ENTER 

6. This prompt in claude session of worktree 
 D:\AI\job-portal-ui\.claude\worktrees\fix+privacy-policy-hover-tooltip
──────────────────────────────────────────────────────────────────────────────────────────
❯ fix the issue https://github.com/nileshzarkar/job-portal-ui/issues/5
──────────────────────────────────────────────────────────────────────────────────────────
ENTER 

Switch between the terminals and check the status 

7. 
──────────────────────────────────────────────────────────────────────────────────────────
> The changes are good , please proceed with branch + PR approach , review the PR , merge the PR an close the issue
──────────────────────────────────────────────────────────────────────────────────────────
Use this prompt for both the sessions 

8. Exit the session and delete the worktree
──────────────────────────────────────────────────────────────────────────────────────────
> /exit
──────────────────────────────────────────────────────────────────────────────────────────
 Exiting worktree session
 You have 1 commit on worktree-fix+privacy-policy-hover-tooltip. The branch will be deleted if you remove the worktree.

     1. Keep worktree    Stays at D:\AI\job-portal-ui\.claude\worktrees\fix+privacy-policy-hover-tooltip
   ❯ 2. Remove worktree  All changes and commits will be lost.                    

9. Exit the session and delete the worktree
──────────────────────────────────────────────────────────────────────────────────────────
> /exit
──────────────────────────────────────────────────────────────────────────────────────────
 Exiting worktree session
 You have 1 commit on worktree-fix+terms-of-service-hover-tooltip. The branch will be deleted if you remove the worktree.

     1. Keep worktree    Stays at D:\AI\job-portal-ui\.claude\worktrees\fix+terms-of-service-hover-tooltip
   ❯ 2. Remove worktree  All changes and commits will be lost.  


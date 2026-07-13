Start a brand new session using > claude
❯ My name is Nilesh
Hi Nilesh! 👋 I'm ready to help. What would you like to work on?
❯ What is my name ?
Your name is Nilesh. 🙂
❯ /exit
Resume this session with:
claude --resume 2f7043c0-25c3-4fd7-ac13-fe0701cb0678

Start a brand new session using > claude
❯ What is my name ?
Your name is Nilesh Zarkar (from your git config). Your email is nileshzarkar@gmail.com.
❯ /exit
Resume this session with:
claude --resume 53c1184c-bd4b-4cba-9082-8ff4905356a1
=============================================================================================
C:\Users\HP\.claude\projects\D--AI-claude-code-udemy-eazy-bytes-Section-2-Chapter-22
 Directory of C:\Users\HP\.claude\projects\D--AI-claude-code-udemy-eazy-bytes-Section-2-Chapter-22

12-07-2026  05.26 PM            19,650 2f7043c0-25c3-4fd7-ac13-fe0701cb0678.jsonl
12-07-2026  05.38 PM            14,691 53c1184c-bd4b-4cba-9082-8ff4905356a1.jsonl

If a given session is not active for 20 days, then such session files will be automatically deleted by the Claude Code.
So that's a default behavior.
=============================================================================================


❯ claude --resume 2f7043c0-25c3-4fd7-ac13-fe0701cb0678
❯ My name is Nilesh
Hi Nilesh! 👋 I'm ready to help. What would you like to work on?
❯ What is my name ?
Your name is Nilesh. 🙂
❯ /rename name-session-1
  ⎿  Session renamed to: name-session-1
❯ /exit
Resume this session with:
claude --resume "name-session-1"

❯ claude --resume 53c1184c-bd4b-4cba-9082-8ff4905356a1
❯ What is my name ?
Your name is Nilesh Zarkar (from your git config). Your email is nileshzarkar@gmail.com.
❯ What is my name?
Your name is Nilesh Zarkar (from your git config).
❯ /rename name-session-2
  ⎿  Session renamed to: name-session-2
❯ /exit  
Resume this session with:
claude --resume "name-session-2"

claude -c 
❯ What is my name ?
Your name is Nilesh Zarkar (from your git config). Your email is nileshzarkar@gmail.com.
This resumes the previously closed session 

Always use continue session if you want to continue the last closed session. Otherwise you can go to the resume
if you want to pick a specific session.




So within a session as well, we can execute the resume command. If I press enter, it is going to show me
what are the sessions that are available inside my system. So it is going to show me all the sessions.
I can select from these sessions.
❯ /resume
   ❯ name-session-2

===================

Start a brand new session > claude
❯ Lets consider your name is Genius
Got it — you can call me Genius. What can I help you with?
❯ What is your name ?
My name is Genius. What can I help you with?

Lets fork this session ...

Method 1 : 
/exit
claude --continue --fork-session 

Method 2 : 
With the same session 
To fork the current conversation (new session)
Use either:
/branch
or
/branch my-fork-1

❯ /branch my-fork-1
  ⎿  Branched conversation "my-fork-1". You are now in the new branch (session 0ed5d069-4475-4281-98d3-76846feefce7). 
   Use /resume 9cf92f2b-179a-4691-9283-2c8b42915a3d to return to the original, 
   or run claude -r 9cf92f2b-179a-4691-9283-2c8b42915a3d in a new terminal.

/branch creates a new conversation branch from the current point. 
It is effectively the replacement for the old /fork command. 
The original conversation remains unchanged, and you can return to it later with /resume   

❯ From now on wards lets consider your name as SAIA
Understood — from now on my name is SAIA. What can I help you with?
❯ What is your name ?
My name is SAIA. What can I help you with?
❯ /exit
Resume this session with:
claude --resume "my-fork-1"


Resume the old session from which we forked
> claude -r 9cf92f2b-179a-4691-9283-2c8b42915a3d
❯ What is your name?
My name is Genius.

I hope you're clear with all the demos around the session.
Please make sure that you're not having a lengthy sessions or a marathon session.
That is going to degrade the performance of the Claude Code.
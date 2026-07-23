The Problem
When you're working in Claude Code, you often wonder things like:
    🤔 How much of my context window have I used?
    💰 How much has this session cost so far?
    🌿 Which Git branch am I currently working on?
Normally, to find these answers you have to:
    Stop what you're doing.
    Run a command.
    Read the output.
    Go back to coding.
This interrupts your concentration and slows you down.
The Solution: Status Line
Claude Code lets you create a custom status line that stays visible all the time (usually at the bottom of the terminal).
Why is it called "Your Status Line"?
The important point is:
    Claude Code doesn't decide what appears there.
You do.
You write a small script that prints whatever information you care about.

For example, your status line could display:
    Context: 42%
    Cost: $0.63
    Branch: feature/packet-writer
    Model: Claude Sonnet
    Time: 14:35
Or maybe:
    Kubernetes: testcluster
    Namespace: test-ers-pcap
    Git: main
    Docker: Running
Claude Code simply runs your script repeatedly and displays its output.

Key takeaway
The status line is like a live dashboard for Claude Code. 
Instead of interrupting your work to check session details, Git information, costs, or other important metrics, you can see them continuously. 
Since it's customizable, you decide exactly what information is most useful for your workflow.





Step 1: Claude Code sends information
    Whenever the status line needs updating, Claude Code sends information to a script.
    It sends data like:
        Model name (Sonnet, Opus, etc.)
        Context usage (%)
        Session cost
        Current Git branch
        Current directory
        Session ID
    It sends all this in JSON format (structured data).
    Think of it like this:
    Claude Code
        │
        │ JSON data
        ▼
    Your Script

Step 2: Your script chooses what to display
    Your script reads the JSON and decides what is important.
    For example:
    Input:
    {
    "model": "Claude Sonnet",
    "context": 42,
    "cost": "$0.35",
    "branch": "feature/login"
    }
    Your script might output:
    Claude Sonnet | ████████░░ 42% | $0.35 | feature/login
    Only the text you print will appear in the status line.

Step 3: Claude Code displays the output
    Claude Code takes the text from your script and shows it at the bottom of the terminal.
        Claude Code
            │
            ▼
        Runs your script
            │
            ▼
        Your script prints text
            │
            ▼
        Status Line
        ------------------------------------------
        Claude Sonnet | 42% | $0.35 | main
        ------------------------------------------

Option 1: Let Claude create the script for you (Easy)
    You don't need to write any code.
    Just type something like: 
    /statusline show model name and context percentage with a progress bar
    Claude Code will:
    Create the script
    Save it in ~/.claude/
    Update the settings
    Start showing the status line

    You don't have to write Bash, Python, or JavaScript.

Option 2: Create it yourself (Manual)
    If you like customization, you can edit the file:
    ~/.claude/settings.json
    Example:
    {
    "statusLine": {
        "type": "command",
        "command": "~/.claude/statusline.sh"
    }
    }
    This tells Claude Code:
    "Whenever you need the status line, run statusline.sh."

Simple diagram
              Claude Code
                   │
         Sends JSON information
                   │
                   ▼
        statusline.sh (your script)
                   │
      Reads the JSON data
                   │
      Chooses what to display
                   │
     Prints simple text to stdout
                   │
                   ▼
      Status Line at bottom of screen

Key takeaway
The status line is powered by a small script. 
Claude Code sends session information (JSON) to the script, the script decides what information to show, and
Claude Code displays the script's output as the status line. 
If you don't want to write the script yourself, Claude Code can generate it for you automatically.

───────────────────────────────────────────────────────────────────────────────
❯ /statusline show model name and context percentage with a progress bar. 
  Makes sure to develop the statusline logic inside my project directory
───────────────────────────────────────────────────────────────────────────────
This will create the file D:\AI\job-portal-ui\.claude\statusline.sh, if the model and context progress is not see fix the status line script and start a new session .
THis also updates the file D:\AI\job-portal-ui\.claude\settings.local.json  to update the path of the statusline.sh.

https://code.claude.com/docs/en/statusline



Create a custom statusline shell script 
D:\AI\job-portal-ui\.claude\statusline-command.sh
Also update the path of this file in D:\AI\job-portal-ui\.claude\settings.json

https://github.com/sirmalloc/ccstatusline


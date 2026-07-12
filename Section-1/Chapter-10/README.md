Created a new project directory named colour-explorer:
mkdir colour-explorer
Navigated into the project directory:
cd .\colour-explorer\
The current working directory is now:
D:\AI\claude-code-udemy-eazy-bytes\Section-1\Chapter-10\colour-explorer

Open colour-explorer folder from NEW VsCode using Open Folder 




Initial Permission Mode – Summary
This setting controls which mode Claude Code starts with for every new conversation.
Available options:
default           – Starts in the default (Manual) mode.
manual            – Claude asks for your approval before making changes. (Alias for default.)
acceptEdits       – Claude automatically applies file edits without asking for confirmation.
plan              – Claude only analyzes and creates a plan; it does not modify files.
bypassPermissions – Claude skips permission prompts and can perform actions without asking (similar to YOLO Mode). Use with caution.



DEFAULT MODE
============
PS D:\AI\claude-code-udemy-eazy-bytes\Section-1\Chapter-10\colour-explorer> claude
Paste the below prompt and wait...
We are in AUTO ACCEPT MODE 
So it may ask permission to run shell or bash commands.
Try to below prompt 

YOLO MODE
=========
Initial Permission Mode: bypassPermissions – Summary
Claude Code will start every new session in Bypass Permissions mode.
Claude will not ask for your approval before:
Editing files
Running terminal commands
Installing packages
Performing other actions
This is equivalent to YOLO Mode, where permission prompts are skipped automatically.

⚠️ Use with caution: This mode is best suited for trusted projects or isolated development environments. For production or sensitive projects, Manual (Default) mode is generally the safer choice.

Key takeaway: Setting bypassPermissions as the Initial Permission Mode makes every new Claude Code session start with automatic permission bypass, eliminating approval prompts.

Otherwise the native UI as of now, it does not support YOLO mode.
Delete all that was created and Now we try AGAIN with YOLO mode 
PS D:\AI\claude-code-udemy-eazy-bytes\Section-1\Chapter-10\colour-explorer> claude --dangerously-skip-permissions
──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
❯ Try "how does <filepath> work?"
──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
  ⏵⏵ bypass permissions on (shift+tab to cycle) · ← for agents · shift+click to native select


PLAN MODE
=========
Delete all that was created and Now we try AGAIN with PLAN mode 
Shift to PLAN MODE >>> SHIFT+TAB
──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
❯ [Pasted text #1]
──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
  ⏸ plan mode on (shift+tab to cycle) ·
Note: Claue may ask few or more questions depending on complexity of the task to which the user will have to respond.






Prompt:
"
Build me a beautiful "Color Palette Explorer" web application using Quarkus 3, Java 21, and Maven. Create a modern responsive web application (not REST APIs). Serve the application directly from Quarkus. Display 20 handpicked beautiful colors in a responsive grid. Each color card should show the color name, HEX, RGB, and HSL values. On hover, the card should scale with a shadow effect. On click, change the page background, copy the HEX code to the clipboard, and show a toast notification saying "Copied HEX to clipboard!". Add a search bar for real-time filtering, a dark mode toggle, an animated hero section, and a "Recently Viewed" section showing the last five clicked colors. Save clicked colors with timestamps to a local JSON file. Generate the complete Quarkus project, including HTML, CSS, JavaScript, Java classes, Maven configuration, and start the application. Follow Quarkus best practices.
"



This prompt is asking Claude Code to build an entire Quarkus web application from scratch, just like the Node.js example, but using Quarkus, Java, and Maven instead.
Here's the breakdown:

1. Create a Quarkus project
    Claude should:
        Initialize a new Quarkus 3 project.
        Use Java 21.
        Configure Maven.
        Add all required Quarkus dependencies.

2. Generate the project structure
    Claude should create the complete project structure, including:
        pom.xml
        application.properties
        Java source files
        HTML
        CSS
        JavaScript
        Resource folders

3. Build the frontend (Web UI)
    Claude should create a modern web interface containing:
        Hero section
        Responsive color grid
        Search bar
        Dark mode toggle
        Toast notifications
        Smooth animations
        Premium-looking design

4. Implement the required features
    Claude should implement:
        Display 20 handpicked colors
        Show:
            Color name
            HEX value
            RGB value
            HSL value
        Hover animation
        Click animation
        Copy HEX code to clipboard
        Change page background
        Real-time search
        Dark mode
        Recently Viewed section

5. Implement backend functionality
    Using Quarkus and Java, Claude should:
        Save every clicked color
        Store the click timestamp
        Write the data into a local JSON file
        Read the last 5 clicked colors
        Display them in the UI

6. Follow Quarkus best practices
    Claude should organize the project properly by using:
        Java packages
        Static resources
        Configuration files
        Clean project structure
        Maven conventions

7. Generate all required files
    Claude should create everything needed, such as:
        Java classes
        HTML pages
        CSS files
        JavaScript files
        JSON storage file
        Maven configuration
        Quarkus configuration

8. Run the application
    Finally, Claude should:
        Build the project
        Start the Quarkus server
        Make the application available in the browser

In simple words
This prompt is asking Claude Code to act like a full-stack Quarkus developer.
It should:
    Create a Quarkus project.
    Configure Maven.
    Write the Java backend.
    Build the HTML/CSS/JavaScript frontend.
    Implement every requested feature.
    Save data to a JSON file.
    Start the application.
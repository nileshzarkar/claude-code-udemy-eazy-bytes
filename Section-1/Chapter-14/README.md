Approach 3 - settings.json Files (Persistent Configuration)
===========================================================
1. settings.json is the permanent configuration file for Claude Code.
2. Unlike CLI arguments, its settings persist across all future sessions until you change them.
3. It is the recommended ("proper") way to configure Claude for long-term use.
4. Settings can be defined at different levels (hierarchical scopes), such as global or project-specific, 
   allowing different configurations for different projects.

Example
Instead of running this every time:
    claude --model opus --permission-mode acceptEdits
You can configure settings.json once:
    {
        "model": "opus",
        "permissionMode": "acceptEdits"
    }
Now, every time you start Claude: claude
it automatically uses those settings.

Key takeaway: 
Use CLI arguments for temporary, one-time overrides, and settings.json for persistent, long-term configuration.




In Claude Code, Managed Scope refers to a settings scope that is controlled by an administrator or organization, rather than by the individual user.
Think of Claude settings as having multiple levels (scopes), where higher levels override lower ones.
Managed (Organization/Admin)
        ↓
User
        ↓
Project
        ↓
Local overrides (CLI arguments)




==================================================
What is Managed Scope?
==================================================
A managed scope contains settings that are centrally enforced by your company or IT administrator.
For example, an organization may want to ensure:
    Everyone uses a specific model.
    Certain tools are disabled.
    Permission modes are restricted.
    Only approved directories can be accessed.
    Company security policies are followed.
Instead of every developer configuring these individually, the administrator defines them once in the managed settings.

Example
Suppose your company wants everyone to use Sonnet and not bypass permissions.
The managed settings might look like:
{
  "model": "sonnet",
  "permissionMode": "default"
}
When you start Claude:
    claude
Claude automatically uses those settings.
If you try:
    claude --permission-mode bypassPermissions
the managed policy may prevent that override because the administrator has locked it down.

Managed settings locations
If your organization uses the file-based managed settings, the file is called:
    managed-settings.json
It is stored in different locations depending on your operating system:
Windows         > C:\Program Files\ClaudeCode\managed-settings.json
macOS           > /Library/Application Support/ClaudeCode/managed-settings.json
Linux / WSL     > /etc/claude-code/managed-settings.json
These locations typically require administrator privileges to modify, preventing regular users from changing the organization's enforced settings.

Example hierarchy
Suppose you have a Java project:
Home/
│
├── .claude/
│   └── settings.json          ← User settings
│
└── Projects/
    └── packet-manager/
        └── .claude/
            ├── settings.json        ← Shared project settings
            └── settings.local.json  ← Your personal project settings

And if your company enforces policies on Linux:
/etc/claude-code/
    managed-settings.json

This file will be controlled by the system administrators. So whatever settings mentioned inside this file will be applied to every user who are using that specific machine. Cannot be changed by users, often used in company environments. So we can think of this as an organization level rules.    




==================================================
What is User Scope?
==================================================
User Scope contains settings that apply only to you, regardless of which project you're working on.
The settings are stored in:  ~/.claude/settings.json
Here, ~ means your home directory.
Examples:
Windows  >  C:\Users\<your-username>\.claude\settings.json
Linux    >  /home/<your-username>/.claude/settings.json
macOS    >  /Users/<your-username>/.claude/settings.json

Why use User Scope?
Use it for your personal preferences that you want Claude to remember across all projects.
For example, suppose you work on:
Projects/
    packet-manager/
    event-manager/
    billing-service/
If you configure something in User Scope, Claude uses those settings for all three projects.
Example 1: Default Model
    Suppose you always prefer Opus.
    ~/.claude/settings.json
    {
    "model": "opus"
    }
Now when you run: claude
Claude automatically uses Opus for every project.

Example 2: Permission Mode
    Suppose you don't want Claude asking permission every time it edits files.
    {
    "permissionMode": "acceptEdits"
    }
Now every project behaves this way.

Example 3: Coding Style
Maybe you always write Java.
You can add:
{
  "systemPrompt": "Always generate Java 21 code."
}
Now whether you're working on:
    Packet Manager
    Selective Recording
    Grafana dashboards
Claude will remember your Java preference.
Is it shared with teammates?
No.
Suppose your teammate Rahul clones the same repository.
Your file: C:\Users\Nilesh\.claude\settings.json
Rahul's file: C:\Users\Rahul\.claude\settings.json
They are completely separate.
If you change your settings:
{
  "model": "opus"
}
Rahul is not affected.

When should you use User Scope?
Use it for things like:
    Your preferred AI model
    Your preferred permission mode
    Your coding style
    Your personal workflow
    Any settings you want across all projects

User Scope vs Project Scope
| User Scope                          | Project Scope                               |
| ----------------------------------- | ------------------------------------------- |
| Applies to all your projects        | Applies only to one project                 |
| Stored in `~/.claude/settings.json` | Stored in `<project>/.claude/settings.json` |
| Personal                            | Shared with the team (if committed to Git)  |
| Not visible to teammates            | Can be shared with teammates                |

Example
Suppose you have these projects:
~/Projects
│
├── Packet-Manager
├── Selective-Recording
└── Billing-Service
Your User Scope is:
~/.claude/settings.json

It might contain:
{
  "model": "opus",
  "permissionMode": "acceptEdits"
}

Now, when you open any of those three projects and start Claude, it automatically uses Opus and acceptEdits unless a higher-priority setting (such as a project or managed setting) overrides it.




==================================================
What is Project Scope?
==================================================
Project Scope contains settings that apply only to one specific project (repository).
The settings are stored inside the project itself:
    <project>/.claude/settings.json

Example:
packet-manager/
│
├── src/
├── pom.xml
└── .claude/
    └── settings.json
Unlike User Scope, these settings are shared with everyone working on the project (if committed to Git).

Why use Project Scope?
Use Project Scope when the entire team should use the same Claude configuration.
Instead of every developer configuring Claude individually, the project itself defines the settings.
Example 1: Java Version
Suppose your project uses Java 21.
.claude/settings.json
{
  "systemPrompt": "Always generate Java 21 code."
}
Now everyone working on this repository gets Java 21 code suggestions.

Example 2: Testing Rule
Your team follows Test-Driven Development (TDD).
{
  "systemPrompt": "Always write JUnit tests before implementation."
}
Now Claude follows this rule for everyone on the project.

Example 3: Project-Specific Model
Suppose your architecture team wants everyone to use Opus for this repository.
{
  "model": "opus"
}
Whenever anyone opens this project, Claude uses Opus (unless restricted by a higher-priority managed policy).

Why is it usually committed to Git?
Because the settings become part of the project.
Example:
packet-manager/
│
├── src/
├── pom.xml
├── README.md
└── .claude/
      settings.json

When another developer clones the repository:
    git clone packet-manager
they automatically get the same Claude settings.
This ensures everyone has a consistent experience.

Real-life Example
Imagine your team works on Packet Manager.
The team decides:
    Use Java 21
    Generate JUnit 5 tests
    Follow company coding standards
The project's .claude/settings.json might look like:
{
  "systemPrompt": "Use Java 21, JUnit 5, and follow company coding standards."
}
Now every developer gets the same behavior without configuring Claude individually.

User Scope vs Project Scope
Suppose you have two projects:
Projects/
│
├── packet-manager
└── billing-service
Your User Scope
~/.claude/settings.json
{
  "model": "opus"
}
This applies to all your projects.

Packet Manager Project Scope
packet-manager/.claude/settings.json
{
  "systemPrompt": "Always generate JUnit tests first."
}
This applies only when you're working on packet-manager.

When you switch to billing-service, this project-specific rule is no longer used.

| Feature               | User Scope                | Project Scope                     |
| --------------------- | ------------------------- | --------------------------------- |
| Location              | `~/.claude/settings.json` | `<project>/.claude/settings.json` |
| Applies to            | All your projects         | One specific project              |
| Shared with teammates | ❌ No                      | ✅ Yes (if committed to Git)       |
| Stored in Git         | ❌ No                      | ✅ Usually                         |
| Best for              | Personal preferences      | Team-wide project standards       |

Key idea: Use User Scope for your personal defaults across every project, and Project Scope to define Claude behavior that the whole team should share within a specific repository.




==================================================
What is Local Scope?
==================================================
Local Scope contains settings that apply only to you and only for one specific project.
The settings are stored in:
    <project>/.claude/settings.local.json
Unlike Project Scope, this file:
    ✅ Exists only on your machine
    ✅ Is not shared with teammates
    ✅ Is automatically ignored by Git
    ✅ Is ideal for temporary or experimental settings

Why do we need Local Scope?
Sometimes you want different settings for one project, but you don't want to affect the whole team.
That's exactly what Local Scope is for.

Example Project Structure
packet-manager/
│
├── src/
├── pom.xml
└── .claude/
    ├── settings.json          ← Shared with the team
    └── settings.local.json    ← Only on your machine

Example 1: Personal Model Preference
Suppose your team uses Sonnet, but you want to use Opus while working on this project.
settings.local.json
{
  "model": "opus"
}
Only you use Opus.
Everyone else continues using Sonnet.

Example 2: Experimental Prompt
Suppose you're experimenting with AI-generated tests.
{
  "systemPrompt": "Always generate detailed JUnit 5 tests."
}
Only your Claude follows this instruction.
Your teammates never see it.

Example 3: Temporary Permission Mode
You're doing a refactoring and don't want Claude asking for edit permission repeatedly.
{
  "permissionMode": "acceptEdits"
}
This affects only:
Your machine
This project
It does not affect other projects or other developers.

Why is it ignored by Git?
Imagine your repository:
packet-manager/
│
├── src/
├── pom.xml
└── .claude/
    ├── settings.json
    └── settings.local.json

When you run:
git status
Git sees:
Modified:
    src/UserService.java
It doesn't show:
.claude/settings.local.json
because that file is automatically ignored.
So your personal settings are never accidentally committed.

Real-Life Example (Your Work)
Suppose you're working on the Packet Manager project.
The team shares this configuration:
.claude/settings.json
{
  "systemPrompt": "Use Java 21 and JUnit 5."
}
You personally want Claude to use Opus and automatically accept edits.

Your local file:
.claude/settings.local.json
{
  "model": "opus",
  "permissionMode": "acceptEdits"
}
Only your Claude behaves this way.
Your teammates are unaffected.

Project Scope vs Local Scope
| Project Scope                   | Local Scope                  |
| ------------------------------- | ---------------------------- |
| `settings.json`                 | `settings.local.json`        |
| Shared with everyone            | Only on your machine         |
| Usually committed to Git        | Ignored by Git               |
| Team standards                  | Personal project preferences |
| Everyone gets the same settings | Only you get the settings    |

When you open the Packet Manager project, Claude combines these settings according to its precedence rules. In general:

Managed Scope  = enforces organization-wide policies.
Project Scope  = provides settings shared by the team for that repository.
Local Scope    = lets you customize behavior for your copy of that repository without affecting anyone else.
User Scope     = provides your personal defaults across all projects.

Key Takeaway
Use Local Scope (settings.local.json) when you want project-specific personal settings that should stay on your machine, not be committed to Git, and not affect your teammates. It is perfect for experimentation, temporary workflows, or personal preferences within a single project.


{
  "$schema": "https://json.schemastore.org/claude-code-settings.json",

  "permissions": {           // WE CAN PASS SOME PERMISSIONS
    "allow": [
      "Bash(npm run lint)",
      "Bash(npm run test *)",
      "Read(~/.zshrc)"
    ],

    "deny": [                //  WE CAN DENY SOME PERMISSIONS
      "Bash(curl *)",
      "Read(./.env)",
      "Read(./.env.*)",
      "Read(./secrets/**)"
    ]
  },

  "env": {                  //  WE CAN SET SOME ENVIORNMENT VARIABLES
    "CLAUDE_CODE_ENABLE_TELEMETRY": "1",
    "OTEL_METRICS_EXPORTER": "otlp"
  },

  "companyAnnouncements": [     //  WE CAN SET SOME COMPANY ANNOUNCEMENTS
    "🛡️ Never commit secrets, tokens, or credentials to the repository.",
    "📝 Write meaningful commit messages — future you will thank you."
  ]
}

==========

The rule is simple:
The setting with the highest priority wins.
The priority order is:
1. Managed            (Highest Priority)
2. Command Line Args
3. Local
4. Project
5. User               (Lowest Priority)

1. User (Lowest Priority)
Location: ~/.claude/settings.json
These are your default preferences.
Example:
{
  "model": "opus"
}
Meaning: "I always want to use Opus."

2. Project
Location: project/.claude/settings.json
Team setting:
{
  "model": "sonnet"
}
Now there is a conflict.
User says: Use Opus
Project says: Use Sonnet
Who wins?
✅ Project
Because Project has higher priority.
Result: Claude uses Sonnet.

3. Local
Location: project/.claude/settings.local.json
Suppose you personally want Opus only for this project.
{
  "model": "opus"
}
Now we have
User    : model = opus
Project : model = sonnet
Local   :   model = opus
Who wins?
✅ Local
Result : Claude uses Opus
Only on your computer.
Your teammates still use Sonnet.

4. Command Line Arguments
Suppose you start Claude like this:
claude --model haiku
Now Claude sees
User    : opus
Project : sonnet
Local   : opus
CLI     : haiku
Who wins?
✅ CLI
Because it has higher priority.
Current session uses : Haiku
When you close Claude
CLI disappears.
Next session returns to Local settings.

5. Managed (Highest Priority)
Suppose your company says
{
   "model":"sonnet"
}
Now we have
Managed : sonnet
CLI     : haiku
Local   : opus
Project : sonnet
User    : opus
Who wins?
✅ Managed
Result
Claude uses Sonnet.
Even though you asked for Haiku on the command line, the administrator's policy takes precedence if it is enforced.

|           Priority | Scope                  | Location                                | Managed By            | Applies To                            | Example Setting     | Wins Over            |
| -----------------: | ---------------------- | --------------------------------------- | --------------------- | ------------------------------------- | ------------------- | -------------------- |
| 🥇 **1 (Highest)** | **Managed**            | Admin-managed configuration             | Company/Administrator | Everyone in the organization          | `"model": "sonnet"` | Everything           |
|           🥈 **2** | **Command Line (CLI)** | `claude --model haiku`                  | You                   | Current session only                  | `"model": "haiku"`  | Local, Project, User |
|           🥉 **3** | **Local**              | `<project>/.claude/settings.local.json` | You                   | Only this project on **your machine** | `"model": "opus"`   | Project, User        |
|              **4** | **Project**            | `<project>/.claude/settings.json`       | Team                  | Everyone working on this project      | `"model": "sonnet"` | User                 |
|     **5 (Lowest)** | **User**               | `~/.claude/settings.json`               | You                   | All your projects                     | `"model": "opus"`   | Nothing              |


C:\Users\HP\.claude\settings.json
{
  "model": "sonnet",
  "effortLevel": "high",
  "tui": "fullscreen",
  "theme": "dark",
  "skipDangerousModePermissionPrompt": true
}


CLAUDE.md – Simplified Explanation
The Problem
Imagine you're working on a project and you always follow certain coding rules, such as:
1. Use semantic HTML (<section>, <article>, <nav>) instead of lots of <div> tags.
2. Follow BEM naming for CSS.
3. Use vanilla JavaScript (no jQuery).
4. Use const and let, never var.
5. Keep CSS in separate files (no inline styles).

Without any guidance, you have to repeat these instructions every time you ask Claude Code to generate code.

Another Problem
When Claude doesn't know your project, it may:
1. Create folder structures that don't exist.
2. Use coding patterns different from your team's standards.
3. Ignore your build and testing process.
4. Break coding conventions your team follows.

This doesn't mean Claude is bad at coding—it simply doesn't know your project's rules.

What is CLAUDE.md?
CLAUDE.md is a project instruction file that tells Claude Code:
1. How your team writes code.
2. Which coding standards to follow.
3. How the project is organized.
4. What tools, frameworks, and workflows are used.
5. Any project-specific rules or preferences.

Claude automatically reads this file whenever it works on the project.

Why use CLAUDE.md?
Instead of repeating instructions like:
1. "Use Java 21."
2. "Use Quarkus."
3. "Follow our package structure."
4. "Write JUnit 5 tests."
5. "Don't use inline CSS."

You write them once in CLAUDE.md, and Claude follows them for every task.

Key takeaway
Think of CLAUDE.md as a project's rulebook or onboarding guide for Claude Code. 
It provides the context and coding standards Claude needs, so you don't have to repeat them in every prompt and it generates code that fits your project.

========================

How it works
1. Create a file named CLAUDE.md in your project.
2. Write your project's coding standards, architecture, and instructions in it.
3. When Claude Code starts, it automatically reads CLAUDE.md.
4. Claude remembers these instructions throughout the entire session.

Why is it useful?
Without CLAUDE.md:
1. You repeat the same instructions in every prompt.
2. Claude may generate code that doesn't follow your project's standards.

With CLAUDE.md:
1. You write the instructions once.
2. Claude follows them automatically for every task.
3. Your prompts become shorter and more consistent.

Key takeaway
CLAUDE.md is a project instruction file that teaches Claude how your project works. 
Claude automatically loads it when the project starts, so you don't have to repeat the same instructions in every prompt.

===================

What is CLAUDE.md? (Simplified)

CLAUDE.md is not:
1. Documentation
2. A style guide
It is an onboarding guide for Claude Code.
Think of it as the notes you would give a new senior developer joining your project on their first day.

What does CLAUDE.md tell Claude?
It explains:
🎯 Project goal – What the application is trying to achieve.
✅ Coding rules – Which coding patterns are allowed and which are not.
🛠️ How to make changes – The preferred architecture, coding standards, and workflow.
✔️ How to verify correctness – How to build, test, and validate the code.

Why CLAUDE.md is better
Instead of repeating instructions in every prompt:
- Write the project rules once in CLAUDE.md.
- Claude automatically loads them at the start of each session.
- Every conversation follows the same rules.

==============

Getting Started with CLAUDE.md (Simplified)
1. You don't have to create CLAUDE.md yourself
Instead of manually creating the file, simply run:
/init
Claude Code will:
1. Analyze your project.
2. Detect the build system (e.g., Maven, Gradle).
3. Detect test frameworks (e.g., JUnit).
4. Understand your project's code structure.
5. Generate a starter CLAUDE.md automatically.

You can then edit it to add your own project-specific instructions.

2. Keep CLAUDE.md simple
There is no fixed format.
Write it in simple, human-readable language.
Example:
1. Use Java 21.
2. Use Quarkus 3.
3. Write JUnit 5 tests.
4. Follow constructor injection.


Importing Other Files
Your CLAUDE.md can also reference other files instead of putting everything in one place.
Example:
See @README.md for project overview.
See @package.json for available commands.
or
Git workflow: @docs/git-instructions.md
Claude will automatically read those referenced files when needed.

Why import other files?
Instead of creating one huge CLAUDE.md, you can:
1. Keep CLAUDE.md short and easy to read.
2. Store detailed instructions in separate files.
3. Let Claude load those files only when needed.

Example (Quarkus Project)
Your CLAUDE.md might contain:
1. Project overview: @README.md
2. Coding standards: @docs/coding-guidelines.md
3. Build instructions: @docs/build.md
4. Testing guide: @docs/testing.md

Claude reads these files automatically, so your main CLAUDE.md stays clean while still providing complete project context.

===============


Where to Place CLAUDE.md (Simplified)
You can place CLAUDE.md in different locations depending on where you want the instructions to apply.

1. Home Folder (~/.claude/CLAUDE.md)
    Purpose:
    1. Applies to all Claude Code sessions on your computer.
    2. Stores your personal preferences.
    Example:
    - Always use Java 21.
    - Prefer Maven over Gradle.
    - Explain code in simple language.

2. Project Root (./CLAUDE.md)
    Purpose:
    1. Applies only to that project.
    2. Can be committed to Git and shared with your team.
    Example:
    - Use Quarkus 3.
    - Follow Resource → Service → Repository architecture.
    - Use constructor injection.
    - Write JUnit 5 tests.
    - Run mvn clean verify before completing any task.

3. CLAUDE.local.md
    Purpose:
    1. Stores personal project-specific instructions.
    2. Should be added to .gitignore so it isn't shared with others.
    Example:
    - Use my local PostgreSQL database.
    - Run the application on port 8085.

            Now suppose you ask Claude
            Add a new REST endpoint for packet statistics.
            Claude reads BOTH files.
            It knows:
            From CLAUDE.md
                Use Quarkus
                Java 21
                Constructor Injection
            AND from CLAUDE.local.md
                Use localhost database
                Port 8085
                Dev profile
                Skip integration tests
            So Claude generates code matching your environment, without affecting anyone else.    

4. Parent Directories
    Purpose:
    Useful for monorepos (multiple projects in one repository).
    Child projects automatically inherit instructions from the parent folder.
    Example:
    company/
    │
    ├── CLAUDE.md      ← Common company rules
    │
    ├── project-a/
    │
    └── project-b/
    Both project-a and project-b use the parent CLAUDE.md.

5. Child Directories
    Purpose:
    Place a CLAUDE.md inside a specific subfolder to define rules only for that folder.
    Claude loads it automatically when working in that directory.
    Example:
    my-project/
    │
    ├── CLAUDE.md          ← Rules for entire project
    │
    └── frontend/
        └── CLAUDE.md      ← Extra rules only for frontend


Which one should you use?
For most developers:
✅ ~/.claude/CLAUDE.md  → Personal preferences for all projects.
✅ ./CLAUDE.md          → Team/project-specific rules (most common).
✅ CLAUDE.local.md      → Your personal overrides that shouldn't be shared.


Key takeaway
Think of the different locations as different levels of instructions:
Home Folder                       → Applies to all your Claude session globally
Project Root (./CLAUDE.md)        → Applies to a given project. Can be shared with the team via Git.
CLAUDE.local.md                   → Personal overrides, add to .gitignore
Parent Directory                  → Useful for mono repos where both root/CLAUDE.md and /root/foo/CLAUDE.md are
                                    pulled automatically
Child Directory                   → Claude pulls these in on demand when working in those folders


===================


What to Include in CLAUDE.md (Good Practices)
Include information that helps Claude understand how your project works.
✅ 1. Technologies and Versions
    Tell Claude which technologies your project uses.
    Example : Java 21 / Quarkus 3.25 / Maven / JUnit 5 / Mockito / PostgreSQL
    Why? : Claude won't generate code using Java 8, Spring Boot, or other technologies by mistake.
✅ 2. Project Structure
    Explain what each folder is for.
    Example
        src/main/java
        ├── resource
        ├── service
        ├── repository
        ├── entity
    Why? : Claude knows exactly where new classes should go.
✅ 3. Build, Run and Test Commands
    Tell Claude how your project is built.
    Example
        Build: mvn clean install
        Run: mvn quarkus:dev
        Tests: mvn test
    Why? : Claude knows which commands to execute.
✅ 4. Non-Negotiable Rules
    Rules that must always be followed.
    Example
        Use constructor injection.
        Never use field injection.
        Always write JUnit 5 tests.
        Always log exceptions.
        Never commit generated files.
    Why? : Claude consistently follows your team's standards.
✅ 5. Banned Patterns
    Tell Claude what not to do.
    Example
        Don't use Lombok.
        Don't use System.out.println().
        Don't use TestNG.
        Don't use inline SQL.
    Why? : Claude avoids generating unwanted code.
✅ 6. Team Workflow
    Explain how your team works.
    Example
        Create a feature branch.
        Run all tests.
        Open a Pull Request.
        Never push directly to main.

What NOT to Include (Bad Practices)
These don't add value or can be risky.
❌ 1. Secrets
    Never write: Database Password / AWS Secret Key / GitHub Token
    Why? : These are sensitive credentials and should never be stored in CLAUDE.md.

❌ 2. Formatting Rules Already Enforced
    Don't write things like:
        Always use 4 spaces.
        Use braces on new line.
        Use double quotes.
    Why? : Tools like Checkstyle, Spotless, Prettier, or ESLint already enforce these rules automatically.

❌ 3. Huge Documentation
    Don't copy an entire README into CLAUDE.md.
    Example: 100 pages of project documentation...
    Better approach : See @README.md
    Claude will read it when needed.

❌ 4. Too Many Instructions
    Don't write hundreds of rules.
    Example:
    Rule 1
    Rule 2
    Rule 3
    ...
    Rule 250

    Why? : Important rules get buried, making it harder for Claude to identify what really matters.


    
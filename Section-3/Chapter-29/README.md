1. Show all uncommitted changes
D:\AI\job-portal-ui : make some simple non-breaking change in few files CLAUDE.md and index.html, add a file 
Instead of typing:
    git status
    git diff
Simply ask Claude:
    Show me a summary of all uncommitted changes.
Claude will internally run commands like:
    git status
    git diff
and summarize:
    Modified:
    - CLAUDE.md
    - index.html
    New Files:
    - dummy_file.txt

2. Commit and Push
Instead of
    git add .
    git commit -m "Implemented login page"
    git push
Just say
    commit and push the two modified files but delete the dummy file
Claude may reply:
    I found changes in 2 files.
Proposed commit message:
    Update page title and CLAUDE.md
Shall I proceed?
    Approve it.
Claude runs
    git add .
    git commit -m "Update page title and CLAUDE.md"
    git push

3. Create a Feature Branch
Instead of
    git checkout -b ui-improvements
Ask
    Create a feature branch called ui-improvements and switch to it.
Claude runs
    git checkout -b ui-improvements

4. Push Branch and Create PR
    Change the title back to Job Portal in index.html
Once you've finished coding, say
    Commit the modified file and Push this branch and create a pull request with a summary of the changes.
Claude will
    git push origin ui-improvements
    gh pr create
It automatically generates
    PR title
    PR description
Summary
Example
    Title:
    Improve UI responsiveness
    Description:
    - Added responsive navbar
    - Improved spacing
    - Fixed footer layout

5. Review the PR and Merge
Suppose someone approved your PR.
Just ask
    Review the pull request and merge it into the master branch.
Claude may
    check CI status
    read comments
    merge
using
    gh pr view
    gh pr merge

6. Switch Back to Main and Delete Branch
Instead of
    git checkout main
    git branch -d ui-improvements
    git push origin --delete ui-improvements
Simply say
    Switch back to master and delete the ui-improvements branch locally and remotely.
Claude performs everything automatically.

7. Fix a GitHub Issue
Onpurpose delete the end tag in index.html
<title>JobPortal - Find Your Dream Job Today 
Create an issue in Github branch 
https://github.com/nileshzarkar/job-portal-ui/issues/2
Title: Missing </title> tag
Description: 
index.html has the missing end tag </title>
<title>JobPortal - Find Your Dream Job Today

Suppose your GitHub has
    Issue #2
    Missing </title> tag
Ask Claude
    Please look at issue 2 and fix the problem.
Claude will
    read Issue #12
    inspect your code
    make the required changes
    explain what it changed

8. Commit, Push and Close Issue
After verifying the fix, ask
    Commit and push this fix directly in master, then close issue 2.
Claude will
    create a commit
    push it
    close the GitHub issue
using commands like
    git add .
    git commit
    git push
    gh issue close 12


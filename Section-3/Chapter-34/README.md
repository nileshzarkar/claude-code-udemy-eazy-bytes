Just like we fixed the hovering issue for footer
 - Privacy Policy
 - Terms of Service
 - Cookie Policy
We also need to fix the issue for 
 - Contact Us

When user clicks on the link we get navigated to new form , but we are not displaying any hovering text as of now.

-----------------------------------
Create an issue :
Title: Inside the footer, when user hovers on "Contact us" no text being displayed 
Description: 
Inside the footer when user overs on "Contact us" no text being displayed. User click on this link to navigate to Contact page where a message can be sent to admin about the problem they are facing. So we need to display some help text around this when user hover.

<img width="985" height="156" alt="Image" src="https://github.com/user-attachments/assets/6547bca2-0db6-40e3-be8b-cc7bc876a8d0" />

https://github.com/nileshzarkar/job-portal-ui/issues/10

-----------------------------------

As soon as I click on this create, an issue is going to be created. We know that. 

But for the Claude Code to act on this issue, we need to tag the Claude bot by using @claude I can mention @claude directly inside the title or inside the description, which will automatically make Claude to work on this defect.

But in a typical enterprise application, how it is going to work is someone from QA team, they're going to create the issue or the defect. And some other developer or product owner or scrum master, what they can do is, inside the comments of the issue, they can type in comments section
@claude - Fix this issue 


So whatever I'm providing as a comment here, this will be provided as a prompt to the workflow that we have developed.
So let me comment as soon as I commented, since I tagged the Claude bot first, it is going to react with this emoji. 
That means it saw this comment and it is trying to react based upon the workflow that we have defined.
---
@claude claude bot 1m ago – with Claude
    Claude Code is working…
I'll analyze this and get back to you.
---
Again after some time 
@claude claude bot 1m ago – with Claude
Fixing footer "Contact Us" tooltip
    1. Read the issue and locate the footer code
    2. Identify the cause — "Contact Us" link is missing the hover tooltip that other footer links have
    3. Add help-text tooltip to "Contact Us"
    4. Lint and commit
---
Again after some time 
@claude claude bot 1m ago – with Claude

Claude finished @nileshzarkar's task in 58s —— View job • claude/issue-10-20260720-1725 • Create PR ➔
Fixed the footer "Contact Us" tooltip ✅
    1. Read the issue and locate the footer code
    2. Identify the cause — "Contact Us" link was missing the hover tooltip
    3. Add help-text tooltip to "Contact Us"
    4. Commit and push

Root cause: In src/components/Footer.jsx, the other bottom-row links (Privacy Policy, Terms of Service, Cookie Policy) each render a role="tooltip" span that fades in on hover, but the Contact Us link was missing that span — so hovering showed no help text.

Fix: Added a matching tooltip to the Contact Us <Link> using the exact same styling/animation as its siblings, so it stays visually consistent:

It appears on hover and keyboard focus (group-focus), matching the accessibility behavior of the neighboring links.

Note: I couldn't run npm run lint (the command wasn't approved in this environment), but the change only replicates the already-linted tooltip pattern from the sibling links.

· Branch: claude/issue-10-20260720-1725
The branch created by Claude start withe Issue number it is resolving.

Now you as a developer can 
- review the changes
- create PR
- deploy the changes to verify the changes

But when the PR is created, we have another workflow which will get triggered automatically.
What is that workflow?
It is the claude-code-review.yml.
So as soon as a pull request is opened, these jobs are going to be executed.
And based upon these jobs, the pull request will be automatically reviewed by the Claude Code.


Claude Code will review the PR after you create the PR 
or 
you can add a comment @claude please reiview the PR if the PR is already created and it might have failed for some reason.

PR Review — Add hover tooltip to footer "Contact Us" link
    Gather context (read Footer.jsx and the diff)
    Review the change
    Post review feedback
I re-reviewed the change in src/components/Footer.jsx (lines 196–203). This looks good — I'd approve it. ✅


──────────────────────────────────────────────────────────────────────────────────────────────────────
! git pull
──────────────────────────────────────────────────────────────────────────────────────────────────────

PS D:\AI\job-portal-ui> npm run dev

So these are typical enterprise setup on how they leverage Claude Code.
Not always developers are going to use inside their local system.
They can integrate with their enterprise tools like GitHub, Slack, Zera, based upon their project requirements.


If you want to give your custom prompt for review 
D:\AI\job-portal-ui\.github\workflows\claude-code-review.yml

remove these lines:
          plugin_marketplaces: 'https://github.com/anthropics/claude-code.git'
          plugins: 'code-review@claude-code-plugins'
          prompt: '/code-review:code-review ${{ github.repository }}/pull/${{ github.event.pull_request.number }}'
          # See https://github.com/anthropics/claude-code-action/blob/main/docs/usage.md
          # or https://code.claude.com/docs/en/cli-reference for available options

Add:
prompt: |
REPO: ${{ github.repository}}
PR NUMBER: ${{ github.event.pull_request.number}}

Please reivew this pull request and provide feedback on:
- Code quality and best practices
- Potential busg or issues
- Performance considerations
- Security concerns
- Test coverage

Use the repository's CLAUDE.md for guidance on style and conventions. Be constructive and helpful in your feedback.

Use 'gh pr comment' with your Bash tool to leave your review as a comment on the PR.











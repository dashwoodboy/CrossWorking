# Application Structure

This document will contain information about the Android app's behavior, look and feel.

## Screens

Simple text about each app screen.

### Sign Up

Sign up screen to create an account. Has option to move to Sign In Screen. Has three fases:

#### Account Info

Requires:

* Email
* Password

#### Profile Info

Requires:

* Name
* Picture (Optional)
* About (Optional)

#### Skill Info

* User's skills (Optional) - use [Skill List](#skill-list)

### Sign In

Requires:

* Email
* Password

### Feed

Show list of ideas catered to the user's skills.

* Creator Name and Picture (must have userId)
* Title
* Short description
* Days since created
* Some common skills (Name only)

### Particular Idea

Show all details of an idea.

* Creator Name and Picture (must have userId)
* Title
* Short description
* Description
* Skills

If the user visiting is the creator, have a delete button and an edit button. If it's not, then have an apply button that shows if you have not applied, applied, been accepted or rejected.

### Create Idea

Screen with different inputs in order to create an idea. Requires:

* Title
* Short description
* Description

Afterwards navigate to skill list -> use [Skill List](#skill-list)

### Edit Idea

Similar screen to [Create Idea](#create-idea) but will serve to update an idea. Should show already existent data on idea.

### Profile

Show profile info.

* Name
* About
* Skills
* Ideas - Button

If it's the user's profile:

* Candidatures - Button
* Results - Button
* Edit - Button -> [Edit Profile Screen](#edit-profile)
* Notifications - Button -> [Notifications](#notifications)
* Logout - Button

### Edit Profile

Show all profile information in input prompts in order to change profile data.

### Skill List

Screen to see and add, remove or edit skills to a user or idea.

1. Starts with empty screen and an add button.
2. Clicking the button prompts an input for a category (can only select one from the database).
3. Then one for the skill name and additional info. Once a skill is added, we go back to previous section where we should see the skill on screen. 
4. This will be a cycle where the user can introduce up to 10 skills.

### Notifications

Show unseen notifications.

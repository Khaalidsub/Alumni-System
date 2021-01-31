# Alumni-System

### Introduction

This repository is meant for the alumni system. It is meant for the team to have access for the shared documents,code and whatever is required to be shared among the team.

## Git installation and Github Desktop

In order to use git in your pc/laptop , you have to install git first.
[Git](https://git-scm.com/downloads)

Git uses the command line and it might be difficult for new users
Github has a desktop GUI application that might help you
[Github Desktop](https://desktop.github.com/)

In order to pull this repository , you have to use these following commands in your git bash :

```

git clone https://github.com/Khaalidsub/Alumni-System

cd Alumni-system

```

You have pulled the repository, look for the new folder that has been created.
for example if you were in your desktop.

for further information , here is a tutorial :
[git video tutorial](https://www.youtube.com/watch?v=SWYqp7iY_Tc)

## Project Structure

Since we are working with different modules, the repository is seperated into different branches

- main -> The Completed System will be pushed here in the future
- Developing_Branch -> When we are trying to Integrate the modules together

- Reporting_Branch -> for Group impostor
- User_Branch -> for Group Semicolon
- Mobile_Branch -> for Group Hive
- Alumni_Branch -> for Group Sus
- Event_Branch -> for Group Backspace

To chech all the available branches :

```
git branch -a
```

In order to change to your branch, use the following command :

```

git switch BRANCH_NAME

```

for example

```
git switch User_Branch
```

Just make sure you did not change anything while you are changing branches, it might give you an error.
and I hope you use your groups branch only.

## Basic Git Commands

Whenver you changed something within your branch(e.g added a new model, or changed document)
and would like to share with everyone, use the following commands :

```
git add .

git commit -m  " Write your message about what you changed/added here "

git push
```

Important :

**Make sure you are pushing in the correct branch**

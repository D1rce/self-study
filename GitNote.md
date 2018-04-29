# 本文为Git入门笔记 #

在此鸣谢廖雪峰老师的git 教程，让我轻松入门

[廖雪峰的官方网站](https://www.liaoxuefeng.com/)

[学习 Git 好用的可视化网站](https://learngitbranching.js.org/?demo)

## 安装Git ##

git config 能够配置的东西很多

`git config --global user.name "Your Name"`

`git config --global user.email "email@example.com"`
    
## 常用命令 ##

`git add`是将文件 暂存

`git add -A`命令：相当于对修改文件执行git add操作；对删除文件执行git rm;对本地新增文件执行git add。

`git rm`我的文件

`git rm -r`我的文件夹 此处-r表示递归所有子目录，如果你要删除的，是空的文件夹，此处可以不用带上-r。

`git mv befname afname`改名

`git commit -m "msg"`是提交暂存

`git status`查看当前状态

`git log`查看 详细的log

`git log --pretty=online`简易版本

`git reflog` 查看log操作的日志

`git reset --hard HEAD^` 恢复到上一个版本

`git reset --hard commit_id` 根据一个ID 回复版本

`git reset HEAD readme.txt`  当我们用HEAD时，表示最新的版本。

`git checkout -- file`可以丢弃工作区的修改：

`git diff`  查看不同

`git checkout -b dev` 创建分支dev

`git branch dev` 创建分支

`git checkout dev` 切换分支

`git branch` 查看当前分支

`git merge dev` 合并分支dev

`git branch -d dev` 删除 dev

`git branch -D feature-vulcan`  强行删除 已经提交过代码的  分支

`git log --pretty=oneline --abbrev-commit` 查看略称分支

`git log --graph --pretty=oneline --abbrev-commit` 查看略称分支图表

`git stash` 可以把当前工作现场“储藏”起来，等以后恢复现场后继续工作，可以多次 stash

`git stash list` 查看所“储藏”列表

`git stash apply` 回复不删

`git stash pop` 回复且删除

`git stash apply stash@{0}` 指定某一个 

`git tag v1.0` 创建新标签

`git tag v1.0 6224937` 指定版本创建新标签

`git show v0.9` 查看

`git tag` 查看全部标签

`git tag -a v0.1 -m "version 0.1 released" commit_id` 创建带有说明的标签，用-a指定标签名，-m指定说明文字

`git tag -d v0.1` 删除标签

`git push origin v1.0` 如果要推送某个标签到远程，使用命令git push origin <tagname>：

`git push origin --tags` 一次性推送全部尚未推送到远程的本地标签：

## 远程仓库使用 ##

`git clone url` 克隆代码

`git remote add origin git@github.com:yourgithubname/learngit.git` 关联远程 仓库

`git remote -v` 显示对应克隆的代码地址

`git remote show origin` 查看详情

`git remote rm origin` 删除关联

`git remote rename origin origin1` 修改名字

`git push -u origin master` 第一次推送master分支的所有内容；

`git push origin master` 推送最新修改；

`git fetch origin` 抓取远端代码

`git branch -ｒ` 先查看远程分支

`git branch -r -d origin/branch-name` 删除远程分支
  
`git push origin :branch-name`  推送提交所删除的远程分支

`git tag -d v0.9` 先从本地删除

`git push origin :refs/tags/v0.9` 然后，从远程删除。删除命令也是push，但是格式如下：


## 小结 ##

初始化一个Git仓库，使用git init命令。

添加文件到Git仓库，分两步：

- 第一步，使用命令git add <file>，注意，可反复多次使用，添加多个文件

- 第二步，使用命令git commit，完成。

要随时掌握工作区的状态，使用`git status`命令。

如果`git status`告诉你有文件被修改过，用`git diff`可以查看修改内容。

首先，Git必须知道当前版本是哪个版本，在Git中，用HEAD表示当前版本，也就是最新的提交3628164...882e1e0（注意我的提交ID和你的肯定不

一样），上一个版本就是HEAD^，上上一个版本就是HEAD^^，当然往上100个版本写100个^比较容易数不过来，所以写成HEAD~100。

HEAD指向的版本就是当前版本，因此，Git允许我们在版本的历史之间穿梭，使用命令git reset --hard commit_id。

穿梭前，用`git log`可以查看提交历史，以便确定要回退到哪个版本。

要重返未来，用`git reflog`查看命令历史，以便确定要回到未来的哪个版本。

暂存区是Git非常重要的概念，弄明白了暂存区，就弄明白了Git的很多操作到底干了什么。

现在，你又理解了Git是如何跟踪修改的，每次修改，如果不add到暂存区，那就不会加入到commit中。

场景1：当你改乱了工作区某个文件的内容，想直接丢弃工作区的修改时，用命令`git checkout -- file`。

场景2：当你不但改乱了工作区某个文件的内容，还添加到了暂存区时，想丢弃修改，分两步，第一步用命令`git reset HEAD file`，就回到了场

景1，第二步按场景1操作。

场景3：已经提交了不合适的修改到版本库时，想要撤销本次提交，参考版本回退一节，不过前提是没有推送到远程库。

当Git无法自动合并分支时，就必须首先解决冲突。解决冲突后，再提交，合并完成。

用`git log --graph`命令可以看到分支合并图。

Git用<<<<<<<，=======，>>>>>>>标记出不同分支的内容，我们修改如下后保存

如想删除github 的仓库，仓库 >> settings >> Danger Zone >> Danger Zone >>> delete this repository

## 分支策略 ##

在实际开发中，我们应该按照几个基本原则进行分支管理：

首先，master分支应该是非常稳定的，也就是仅用来发布新版本，平时不能在上面干活；

那在哪干活呢？干活都在dev分支上，也就是说，dev分支是不稳定的，到某个时候，比如1.0版本发布时，再把dev分支合并到master上，在master

分支发布1.0版本；

你和你的小伙伴们每个人都在dev分支上干活，每个人都有自己的分支，时不时地往dev分支上合并就可以了。

但是，并不是一定要把本地分支往远程推送，那么，哪些分支需要推送，哪些不需要呢？

master分支是主分支，因此要时刻与远程同步；

dev分支是开发分支，团队所有成员都需要在上面工作，所以也需要与远程同步；

bug分支只用于在本地修复bug，就没必要推到远程了，除非老板要看看你每周到底修复了几个bug；

feature分支是否推到远程，取决于你是否和你的小伙伴合作在上面开发。

总之，就是在Git中，分支完全可以在本地自己藏着玩，是否推送，视你的心情而定！

![](https://i.imgur.com/EFA0U4d.png)

## 忽略规则.gitignore ##

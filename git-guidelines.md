# Git Guidelines 
#### Before starting to work
- make sure you are on the correct branch (example: `correctbranch`): 
```bash
git checkout correctbranch
```
- make sure you are on the latest version of the branch:
```
git pull
```
#### When finishing a significant code change
- add all relevant files (example: `file1`...`file3`):
```
git add file1 file2 file3
```
or all files (make sure no unneeded files are added):
```
git add .
```
- create a commit
```
git commit -m "message - what did you change?"
```
- `push` (upload) the commit to `origin` (usually GitHub):
```
git push
```
#### After finishing a task
- (after committing and pushing) go to GitHub and open a pull request (PR) from your work branch to `master`
#### Before starting a new task
- `checkout` (change branch to) `master`
```
git checkout master
```
- create a new branch (example: `newbranch`) based on `master`
```
git checkout -b newbranch
```
### Troubleshooting
##### When using `checkout`
- to successfully `checkout`, there can be no uncommitted modified files - `commit` or undo your changes
##### When using `push`
- make sure you aren't trying to `push` to the `master` branch - it's protected and cannot be pushed to directly
- if you are pushing a new branch (example: `newbranch`, it doen't exist in `origin`. Use 
```
git push --set-upstread origin newbranch
```

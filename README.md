# Today I learned 
## Will post stuff I learn during my day to day life
---
- Mounting a drive, instead of using UI, going to files and clicking files.

 steps

- create a folder using command `mkdir /media/sharma/X`
- find all the disks available using `sudo fdisk -l`
- mount the disk at folder using `sudo mount /dev/sda6 /media/sharma/X`

---

- What are first class citizen in programming language?

- Any type, object, entity which has all opertaion generally available to other entities, like being passed as argument, returned from function, modified and assigned an value.

---

- How to copy the data from redis server to local redis server?

- Although there are SAVE and BIGSAVE command, but still their is cool way to do.
- go to local redis server and run this command `redis-cli slaveof IP-ADDRESS-OF-OLD-SERVER 6379`
- wait for a while, it will cooy all data, you won't be able to make changes/connect while copy is in progress.
- So after this is complete run this command `redis-cli slaveof no one`
- now we have entire database copied to our local server.

---

- Connecting to redis cli?

- redis-cli -h IP_ADDR_OF_BOX -p 6379

---

- Never use `keys p_*` in production, it will block the incoming call while computation.

- Use SCAN is recommended for production, so you can use something like:  
  `SCAN 0 COUNT 100 MATCH p_*`

---

- Never add column with some default value to a table in production, it blocks incoming request.

- NEVER DO THIS

```
-- read & write block until it is fully rewritten(which could take hours)
ALTER TABLE name ADD COLUMN last_update timestamptz DEFAULT now();

```

- DO THIS INSTEAD (batch update)

```
ALTER TABLE name ADD COLUMN last_update timestamptz;

do {
 numOfRowsUpdated = executeUpdate(
   "UPDATE name SET last_update = ? " +
   "WHERE id IN (SELECT id FROM name WHERE last_update IS NULL LIMIT 5000)",
   now);
} while (numOfRowsUpdate > 0);


```

---
If you need to remove the last commit but want to maintain changes
```
git reset --soft HEAD^
```
---

If you need to ever create a foreign relation while creating a postgres migration, don't forget to include `ON DELETE CASCADE` you can't do it later, later you would need to delete child first then parent, and it would be tedious.
---

whenever you create a unique constraint on table something like 

```
ALTER TABLE school_timing
    ADD CONSTRAINT unique_row_school_times UNIQUE (school_id,school_city, start_time);
```

make sure to create a unique index on such combination while writing migration file, other we will fall into this error https://stackoverflow.com/a/54169587/6451546, in laymen terms, in above sample example, if you have a row with (school_id_A, lucknow, "08:00") and you delete it, later you can't add a row with same info, you would get not unique etc. error.

---

to go to first line in file in vi `1 + G` mind the capital G

to go to end of file  `G` mind the capital G.

---

to commit only one file from list of staged files in git
`git commit --only filename` OR `git commit filename`

---
visualize your git repo:

`git log --oneline --abbrev-commit --all --graph`

---

in some name insensitive OS like mac, if you use `mv` to rename a file, it won't show any diff in git status, use `git mv` instead

---

one can use `printf`in placeof `echo`, since behaviour of `echo` isn't consistant among versions, example try outputting `\n`

---

change date of git commit `git commit --amend --no-edit --date "4 Oct 1987"`

---

a useful git command `git rebase -i HEAD~5

---

If you accidentally amend the last commit and want to get it back, use `git reflog show` to see history, then use something like `git reset HEAD@{1}` to get back changes in unstaged state and the commit where you did `git commit --amend` :)

---

make a file executable in git `git update-index --chmod=+x foo.sh`

---
if you need to partially commit the change in file use command `git add -p`, this will open up interactive mode.

Use `?` for help.

---

merge another branch(f-b) in current branch(mas) but squash all commits of(f-b) `git merge --squash f-b`

---

How/when to use git cherry-pick?

you have multiple feature branch (fa, fb, fc) with multiple commits in each, you can't just simple merge them, as they will bring their own history, one way is to squash but you will have  merge commit,which doesn't looknice...


you can do `git cherry-pick <commit hash of top commit on f-a>` similar for merging f-b and f-c

keep master clean.

---

Use `git rebase --onto` to rebase on any commit fromany commit on any branch, a really very good articl e https://womanonrails.com/git-rebase-onto

---

Search through all changes using `git log -S`

---

Use `git bisect` to find when was first time a bug was introduced, such a beautiful tool.
https://git-scm.com/docs/git-bisect

---

`git reset --soft HEAD^` Will keep the modified changes in your working tree.

`git reset --hard HEAD^`  WILL THROW AWAY THE CHANGES YOU MADE !!!

----

get infomation of any file

`file filename`

----

use `time <command>` to miniter the time taken by command to execute

----


use `echo "same base64 decoded value" | base64 --decode` to decode the base64 message.

----

know status of service

`service postgresql status`

----

Check for last login for users in remote/local client using command `last`

----

Quickly set up a local server to mock a external http call

```
#     To run, use python3 main.py
from flask import Flask
import json

app = Flask(__name__)

@app.route('/')
def example():
   return {
    "data": {
        "message": "This is value of message key",
        "user_type": "This is value of user type"
    }
}

if __name__ == '__main__':
    app.run(port=5000)
```

just need to do `pip3 install flask` before running this file

----

Check uptime of service

`systemctl status <service_name>.service | grep Active`

----

how to export env variable from file

`export $(xargs < ~/Downloads/env.integration)`

----

see bash history of other user

`
sudo vim /home/USER_YOU_WANT_TO_VIEW/.bash_history
`

----

start rabbitmq server using command `rabbitmq-server` or `brew services start rabbitmq`

----

remember authentication checks credentials, authorization checks permissions

----


port forwarding via openSSH

ssh -L local_port:destination_server_ip:remote_port ssh_server_hostname

------
Go not able to run

https://stackoverflow.com/questions/54966224/cant-run-go-permission-denied
also see how to add user to group, interesting find

------------
 ALL < DEBUG < INFO < WARN < ERROR < FATAL < OFF. 
-----------
access elements in redis zset

zrange <key> score_min(starting from 0) score_max(-1 for all cases) WITH_SCORES(in case you want to print scores also)

----

if we crate a new application id in kafka, it willstart from off set 0, data that it has in kafka queue in old data as well.
----

ESB : enterprise service bus, this is an architectural pattern whereby a centralized service component performs integration between applications. 


---

how to save ssh password for longer, use utility `ssh-add`

---

how to open emoji keyboard in mac : control + command + space

---

use `-p` flag in mkdir to not create directory if it already exists.

---

Life Principle : Leave place in a better place than you discovered it, be it in codebases or life situation or people you meet.
`
----

dictionaries are also called hashmap or key value structure

----`
why add new line at end of file?

* historically the decision was made during C lang standard and many Unix tools expect to work correctly
* line means -> sequence of zero or non-new line and terminating newline char. (if we don't add new line, its not a line)
* unix benifits, cat displays correctly for file ending in new line
* wc -l won't count last line if it doesn't has new line.
----

Predicate functions are functions that return a single TRUE or FALSE .
----
List all running services `systemctl --type=service --state=running`
---------

atomic operations: either they will run completely or not at all. for ex: a process having multiple step is not atomic, as 1 step may happen and then it can fail. but atomic operation are most small unit of work that can be done.


--- 

Diff between heap and stack

- Heap is explicitely defined by programmer and not cleared automatically, not to be confused with Heap data structure.
- Every time we create a obejct, it is store in heap and reference is stored in Stack.
- GC runs on Heap, Stack doesn't need GC because Stack has First in Last out, as soon as func call ends, the variable goes out of stack, thus free, since we don't know which variable to remove, that's why GC runs on HEAP.
- If heap is full we get OutOfMemoryError, if stack is full we get StackOverflow error.


---

GO lang

func (a ABC) DoSomething(input ) output 

here ABC is called function reciever

---

Golang

defer : used to execute the func at the last of untill all current function is completed.
Interesting note is that: the arguments are evaluated immediately, bt actual function call is done later. 

```
defer fmt.Println("Defer World time ", time.Now().UnixNano())
for i := 0; i < 1000000; i++ {
	///
}
fmt.Println("Hello World time ", time.Now().UnixNano())
```

so here the defer world time is early then hello world time, the reason being the argument of defer world time is executed first. 

the defer is helpful while computing latencies

```
defer reporter.ReportAPILatency(r.Method, r.URL.Path, getRawQuery(r), time.Now())
next.ServeHTTP(w, r)
```

So, the time.Now() is evaluated,and the reportAPILatency function later can just subtract from currentTime and get latency.

--------




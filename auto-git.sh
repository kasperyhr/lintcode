cd /d/study/leetcode
git ls-files --others --modified --exclude-standard | while read line ; do IFS='/' read -r -a array <<< "$line"; git add "${array[0]}/"; git commit -m "Problem ${array[0]}"; done
git push origin master
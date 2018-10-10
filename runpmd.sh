pmd -d ./src -R pmd-ruleset-graphql.xml -f csv > pmd-collected.csv
sort -t, -k4 pmd-collected.csv | column -t -s,
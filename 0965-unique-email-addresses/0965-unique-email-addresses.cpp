class Solution {
public:
    int numUniqueEmails(vector<string>& emails) {
        unordered_set<string> unique;

        for (string& email : emails) {
            string local, domain;
            int i = 0;

            while (email[i] != '@' && email[i] != '+') {
                if (email[i] != '.')
                    local += email[i];
                i++;
            }

            while (email[i] != '@')
                i++;

            domain = email.substr(i + 1);

            unique.insert(local + "@" + domain);
        }

        return unique.size();
    }
};

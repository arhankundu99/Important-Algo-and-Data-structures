
// https://leetcode.com/discuss/interview-question/4820505/Google-question/
public class Main {
    private static boolean dfs(Map<String, Set<Integer>> volunteerNameToQuestionIdMap, String volunteerName, Set<Integer> visitedQuestionIds, Map<Integer, String> questionIdToVolunteerNameMatches, List<Question> questions) {
        for (Question question: questions) {
            // Check if it can be mapped to current volunteer name
            if (volunteerNameToQuestionIdMap.get(volunteerName).contains(question.id) && !visitedQuestionIds.contains(question.id)) {
                visitedQuestionIds.add(question.id);
                // Check if the question was already mapped or if the user who took this question can be mapped to other question
                if (!questionIdToVolunteerNameMatches.containsKey(question.id) || dfs(volunteerNameToQuestionIdMap, questionIdToVolunteerNameMatches.get(question.id), visitedQuestionIds, questionIdToVolunteerNameMatches, questions)) {
                    questionIdToVolunteerNameMatches.put(question.id, volunteerName);
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question(1, new String[]{"MAC", "VSCODE"}));
        questions.add(new Question(2, new String[]{"PY", "AI"}));
        questions.add(new Question(3, new String[]{"JAVA", "OS"}));
        questions.add(new Question(4, new String[]{"PY", "NW"}));

        List<Volunteer> volunteers = new ArrayList<>();
        volunteers.add(new Volunteer(1, new String[]{"PY", "NW"}, "A"));
        volunteers.add(new Volunteer(2, new String[]{"AI"}, "B"));
        volunteers.add(new Volunteer(3, new String[]{"JAVA", "NW"}, "C"));
        volunteers.add(new Volunteer(4, new String[]{"JAVA", "NW"}, "D"));

        
        Map<String, List<Integer>> questionToQuestionIdMap = new HashMap<>();
        for (Question q: questions) {
            for (String tag: q.tags) {
                if (!questionToQuestionIdMap.containsKey(tag)) {
                    questionToQuestionIdMap.put(tag, new ArrayList<>());
                }
                questionToQuestionIdMap.get(tag).add(q.id);
            }
        }
        
        Map<String, Set<Integer>> volunteerNameToQuestionIdMap = new HashMap<>();
        for (Volunteer v: volunteers) {
            volunteerNameToQuestionIdMap.put(v.name, new HashSet<>());
            for (String tag: v.tags) {
                if (questionToQuestionIdMap.containsKey(tag)) {
                    for (int questionId: questionToQuestionIdMap.get(tag)) {
                        volunteerNameToQuestionIdMap.get(v.name).add(questionId);       
                    }
                }
            }
        }
        
        Map<Integer, String> questionIdToVolunteerNameMatches = new HashMap<>();
        for (String volunteerName: volunteerNameToQuestionIdMap.keySet()) {
            dfs(volunteerNameToQuestionIdMap, volunteerName, new HashSet<>(), questionIdToVolunteerNameMatches, questions);
        }
        
        System.out.println(questionIdToVolunteerNameMatches);
    }
}
                            
class Question {
    int id;
    String[] tags;
    Question(int id, String[] tags) {
        this.id = id;
        this.tags = tags;
    }
}
                            
class Volunteer {
    int id;
    String[] tags;
    String name;
    
    Volunteer(int id, String[] tags, String name) {
        this.id = id;
        this.tags = tags;
        this.name = name;
    }
}

// Problem: https://leetcode.com/problems/replace-words/solutions/?envType=daily-question&envId=2024-06-07

type TrieNode struct {
    Children map[rune]*TrieNode
    IsEndOfWord bool
}

func NewTrieNode() *TrieNode {
    return &TrieNode{Children: make(map[rune]*TrieNode)}
}

type Trie struct {
    Root *TrieNode
}

func NewTrie() *Trie {
    return &Trie{Root: NewTrieNode()}
}

func (t *Trie) Insert(word string) {
    curr := t.Root

    for _, c := range(word) {
        if curr.Children[c] == nil {
            curr.Children[c] = NewTrieNode()
        }
        curr = curr.Children[c]
    }
    curr.IsEndOfWord = true
}

func (t *Trie) GetPrefix(word string) string {
    curr := t.Root
    for idx, c := range(word) {
        if curr.Children[c] == nil {
            return ""
        }
        curr = curr.Children[c]

        if curr.IsEndOfWord {
            return word[0:idx + 1]
        }
    }
    return ""
}

func replaceWords(dictionary []string, sentence string) string {
    t := NewTrie()

    for _, d := range(dictionary) {
        t.Insert(d)
    }

    words := strings.Fields(sentence)
    for idx, word := range(words) {
        p := t.GetPrefix(word)

        if p != "" {
            words[idx] = p
        }
    }

    return strings.Join(words, " ")
}

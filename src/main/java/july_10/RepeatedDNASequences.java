package july_10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences {
	public List<String> findRepeatedDnaSequences(String s) {
	    Set<Integer> words = new HashSet<>();
	    Set<Integer> doubleWords = new HashSet<>();
	    List<String> rv = new ArrayList<>();
	    char[] map = new char[26];
	    //map['A' - 'A'] = 0;
	    map['C' - 'A'] = 1;
	    map['G' - 'A'] = 2;
	    map['T' - 'A'] = 3;

	    for(int i = 0; i < s.length() - 9; i++) {
	        int v = 0;
	        for(int j = i; j < i + 10; j++) {
	            v <<= 2;
	            v |= map[s.charAt(j) - 'A'];
	            System.out.println(v);
	        }
	        if(!words.add(v) && doubleWords.add(v)) {
	            rv.add(s.substring(i, i + 10));
	        }
	    }
	    return rv;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RepeatedDNASequences aDnaSequences = new RepeatedDNASequences();
		
		System.out.println(aDnaSequences.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));

	}

}

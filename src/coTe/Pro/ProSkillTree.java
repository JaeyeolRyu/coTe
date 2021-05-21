package coTe.Pro;

import java.util.Arrays;

class ProSkillTree {

	public static void main(String[] args) {

		String skill = "CBD";
		String[] skill_trees = { "BACDE", "CBADF", "AECB", "BDA" };

		int ans = solution(skill, skill_trees);
		System.out.println(ans);

	}

	public static int solution(String skill, String[] skill_trees) {
		int answer = 0;

		for (String skillTree : skill_trees) {
			int[] idx = new int[skill.length()];
			Arrays.fill(idx, 27);
			for (int i = 0; i < skill.length(); i++) {

				for (int j = 0; j < skillTree.length(); j++) {

					if (skill.charAt(i) == skillTree.charAt(j)) {

						idx[i] = j;

					}

				}

			}
			if(idx.length == 1) {
				answer++;
			} else {
				
				for (int i = 0; i < idx.length - 1; i++) {

					if (idx[i] > idx[i + 1]) {
						break;
					}
					if (i == idx.length - 2) {
						answer++;
					}
				}
			}
			
		}

		return answer;
	}
}
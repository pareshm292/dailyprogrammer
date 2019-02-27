package com.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FallOutGame {

	private static Set<String> wordset;
	private static String YES = "yes";
	private static Integer MAX_CHANCES = 5;


	private static void initWords() {

		try {
			wordset = Files.lines(Paths.get(new File("C:\\data\\enable1.txt").toURI())).collect(Collectors.toSet());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static List<String> setDifficultyAndGenerateList(int difficulty) {

		List<String> words = wordset.parallelStream().filter(word -> word.length() == difficulty + 5).collect(Collectors.toList());

		List<String> gameWords = new ArrayList<>();
		
		Random random = new Random();
		
		IntStream.range(0, 10).forEach(i -> gameWords.add(words.get(random.nextInt(words.size()))));
		
		return gameWords;
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		initWords();

		boolean playAgain = true;

		while(playAgain) {

			System.out.println("Enter Difficulty Level (1 - 5) :  ");

			int difficulty;
			
			String input = scanner.next();
			
			while(!input.matches("[1-5]")) {
				System.out.println("Incorrect Input, Please Enter Difficulty Level (1 - 5) :  ");
				input = scanner.next();
			}
			
			difficulty = Integer.parseInt(input);
			List<String> words = setDifficultyAndGenerateList(difficulty);

			playGame(words,scanner);
		
			System.out.println("Play Again ? ( Yes / No ) ");

			String choice = scanner.next();

			playAgain = YES.equalsIgnoreCase(choice);
		}
		scanner.close();
	}

	private static void playGame(List<String> words , Scanner sc) {

		String correctWord = words.get(new Random().nextInt(words.size()));
		
		showWords(words);
			
		boolean correctGuess = false;
		
		int chances = MAX_CHANCES;
		
		while(!correctGuess && chances > 0) {
			
			System.out.println("Guess ( " + chances +  " left )");
			String guessedWord = sc.next();
			
			if(checkDiff(guessedWord , correctWord) == 0) {
				System.out.println("You Win!");
				correctGuess = true;
			}
			else {
				chances--;
			}
		}
	}

	private static int checkDiff(String guessedWord, String correctWord) {

		if(guessedWord.length() != correctWord.length()) {
			return -1;
		}
		
		int difference = 0;
		guessedWord = guessedWord.toLowerCase();
		correctWord = correctWord.toLowerCase();
		for(int i = 0 ; i < guessedWord.length() ; i++) {
			if(correctWord.charAt(i) != guessedWord.charAt(i)) {
				difference++;
			}
		}
		System.out.println(guessedWord.length() - difference + "/" + correctWord.length() + " correct !");
		return difference;
	}

	private static void showWords(List<String> words) {
		words.stream().map(word -> word.toUpperCase()).forEach(System.out::println);		
	}

}
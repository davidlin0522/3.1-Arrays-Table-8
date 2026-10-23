import random
import csv
from collections import Counter
from pathlib import Path

# ANSI color codes for terminal display
GREEN = "\033[42m\033[30m"   # Correct letter & spot
YELLOW = "\033[43m\033[30m"  # Correct letter, wrong spot
GRAY = "\033[100m\033[37m"   # Letter not in word
RESET = "\033[0m"

def load_words():
    word_file = Path(__file__).with_name("text.csv")
    try:
        with word_file.open(newline="", encoding="utf-8") as csv_file:
            words = {
                row[-1].strip().upper()
                for row in csv.reader(csv_file)
                if row and len(row[-1].strip()) == 5 and row[-1].strip().isalpha()
            }
    except OSError as error:
        raise SystemExit(f"Could not read word list at {word_file}: {error}") from error

    if not words:
        raise SystemExit(f"No five-letter words found in {word_file}.")
    return words

def evaluate_guess(guess: str, secret: str):
    """
    Evaluates guess against secret using Wordle's 2-pass rule:
    1. Mark all exact matches (Green) first.
    2. Mark remaining matching letters (Yellow) only up to 
       the number of times they appear in the secret word.
    """
    result = [None] * 5
    secret_counts = Counter(secret)

    # First pass: identify GREENs
    for i in range(5):
        if guess[i] == secret[i]:
            result[i] = (GREEN, guess[i])
            secret_counts[guess[i]] -= 1

    # Second pass: identify YELLOWs and GRAYs
    for i in range(5):
        if result[i] is None:
            char = guess[i]
            if secret_counts.get(char, 0) > 0:
                result[i] = (YELLOW, char)
                secret_counts[char] -= 1
            else:
                result[i] = (GRAY, char)

    return result

def format_row(row):
    return " ".join(f"{color} {char} {RESET}" for color, char in row)

def play_wordle():
    words = load_words()
    secret = random.choice(tuple(words))
    max_attempts = 6
    history = []

    print("\n--- WORDLE ---")
    print("Guess the 5-letter word in 6 tries.\n")

    for attempt in range(1, max_attempts + 1):
        while True:
            guess = input(f"Guess {attempt}/{max_attempts}: ").strip().upper()
            if len(guess) != 5 or not guess.isalpha():
                print("Invalid input. Must be exactly 5 letters.")
                continue
            if guess not in words:
                print("Invalid word. Choose a word from the word list.")
                continue
            break

        evaluated = evaluate_guess(guess, secret)
        history.append(evaluated)

        print("\n" + "\n".join(format_row(row) for row in history) + "\n")

        if guess == secret:
            print(f"🎉 Impressive! You won in {attempt} attempts!")
            return

    print(f"Game Over! The word was: {secret}")

if __name__ == "__main__":
    play_wordle()
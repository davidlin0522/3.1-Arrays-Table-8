import random
from collections import Counter

# ANSI color codes for terminal display
GREEN = "\033[42m\033[30m"   # Correct letter & spot
YELLOW = "\033[43m\033[30m"  # Correct letter, wrong spot
GRAY = "\033[100m\033[37m"   # Letter not in word
RESET = "\033[0m"

WORDS = [
    "CRANE", "SLATE", "AUDIO", "ROAST", "PLANT",
    "GHOST", "SHINE", "FLUTE", "BRICK", "CHAIR",
    "LIGHT", "STORM", "WATER", "HEART", "CLOUD"
]

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
    secret = random.choice(WORDS)
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
class LookAndSay:

    def group(self, seq: list) -> list:
        # Bisa pakai cara curang: collections.groupby
        state = seq[0]
        counter = 0
        groups = []
        for s in seq:
            if state == s:
                counter += 1
            else:
                groups = groups + [counter, state]
                counter = 1
                state = s
        else:
            groups = groups + [counter, state]
        return groups

    def generate_sequences(self, total_seq: int) -> list:
        sequences = []
        for i in range(total_seq):
            if not sequences:
                sequences.append([1])
            else:
                current_group = self.group(sequences[-1])
                sequences.append(current_group)
        return sequences

    def print_sequences(self, total_seq: int) -> None:
        sequences = self.generate_sequences(total_seq)
        for sequence in sequences:
            print(' '.join(map(str, sequence)))


if __name__ == '__main__':
    look_and_say = LookAndSay()
    look_and_say.print_sequences(7)

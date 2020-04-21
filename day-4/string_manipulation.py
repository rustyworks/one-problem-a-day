class StringManipulation:

    def swapcase(self, s: str) -> str:
        if not s:
            return s
        else:
            return self.swapchar(s[0]) + self.swapcase(s[1:])

    def swapchar(self, s: str) -> str:
        if s in 'abcdefghijklmnopqrstuvwxyz':
            return s.upper()
        else:
            return s.lower()


if __name__ == '__main__':
    string_manipulation = StringManipulation()
    print(string_manipulation.swapcase('hEllO wOrLd'))
    assert 'HeLLo WoRlD' == string_manipulation.swapcase('hEllO wOrLd')

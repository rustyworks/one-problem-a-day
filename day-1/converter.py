def number_to_words(n: int) -> str:
    TRILLION_LIMIT = 999_999_999_999_999

    is_integer = type(n) == int
    is_positive = n > 0
    is_less_than_trilion = n < TRILLION_LIMIT

    if not (is_integer and is_positive and is_less_than_trilion):
        return ''
    elif n == 0:
        return 'nol'
    else:
        return beautify_words(construct_words(n, 1))


def construct_words(n: int, depth: int) -> str:
    result, remaining = divmod(n, 1000)
    number = suffix = ''
    number = get_number(remaining)
    suffix = get_suffix(depth)

    if result == 0:
        return number
    else:
        return f'{construct_words(result, depth + 1)} {suffix} {number}'


def beautify_words(s: str) -> str:
    s = s.replace('satu belas', 'sebelas')
    s = s.replace('satu ratus', 'seratus')
    s = s.replace('satu ribu', 'seribu')
    s = s.replace('satu juta', 'sejuta')
    s = s.replace('  ', ' ')
    return s.strip()


def get_suffix(n: int) -> str:
    suffix = ''
    if n == 1:
        suffix = 'ribu'
    elif n == 2:
        suffix = 'juta'
    elif n == 3:
        suffix = 'miliar'
    elif n == 4:
        suffix = 'triliun'
    return suffix


def get_number(n: int) -> str:
    if n == 0:
        number = ''
    elif n == 1:
        number = 'satu'
    elif n == 2:
        number = 'dua'
    elif n == 3:
        number = 'tiga'
    elif n == 4:
        number = 'empat'
    elif n == 5:
        number = 'lima'
    elif n == 6:
        number = 'enam'
    elif n == 7:
        number = 'tujuh'
    elif n == 8:
        number = 'delapan'
    elif n == 9:
        number = 'sembilan'
    elif n == 10:
        number = 'sepuluh'
    elif n >= 11 and n < 20:
        number = get_number(n % 10) + ' belas'
    elif n >= 20 and n < 100:
        result, remaining = divmod(n, 10)
        number = get_number(result) + ' puluh ' + get_number(remaining)
    else:
        result, remaining = divmod(n, 100)
        number = get_number(result) + ' ratus ' + get_number(remaining)
    return number


if __name__ == '__main__':
    assert number_to_words(10) == 'sepuluh'
    print(number_to_words(10))
    assert number_to_words(55) == 'lima puluh lima'
    print(number_to_words(55))
    assert number_to_words(1253) == 'seribu dua ratus lima puluh tiga'
    print(number_to_words(1253))
    assert number_to_words(1010101) == 'sejuta sepuluh ribu seratus satu'
    print(number_to_words(1010101))
    assert number_to_words(5400000) == 'lima juta empat ratus ribu'
    print(number_to_words(5400000))
    assert number_to_words(111_111_111_111_111) == 'seratus sebelas triliun seratus sebelas miliar seratus sebelas juta seratus sebelas ribu seratus sebelas'  # noqa
    print(number_to_words(111_111_111_111_111))
    assert number_to_words(555_555_555_555_555) == 'lima ratus lima puluh lima triliun lima ratus lima puluh lima miliar lima ratus lima puluh lima juta lima ratus lima puluh lima ribu lima ratus lima puluh lima'  # noqa
    print(number_to_words(555_555_555_555_555))
    assert number_to_words(-1) == ''
    print(number_to_words(-1))
    assert number_to_words(1.1) == ''
    print(number_to_words(1.1))
    assert number_to_words(1_111_111_111_111_111) == ''
    print(number_to_words(1_111_111_111_111_111))

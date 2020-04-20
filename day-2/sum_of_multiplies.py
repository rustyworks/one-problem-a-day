def sum_below(n: int) -> int:
    return sum(filter(condition([3, 5]), range(1, n)))


def condition(whitelist_numbers: list) -> int:
    def filter_condition(n: int, whitelist_numbers=whitelist_numbers) -> bool:
        for whitelist_number in whitelist_numbers:
            if n % whitelist_number == 0:
                return True
        else:
            return False
    return filter_condition


if __name__ == '__main__':
    print(sum_below(10))
    assert 23 == sum_below(10)
    print(sum_below(1000))
    assert 233168 == sum_below(1000)

def sum_below(n: int, condition: callable) -> int:
    return sum(filter(condition, range(1, n)))


def condition(whitelist_numbers: list) -> int:
    def filter_condition(n: int, whitelist_numbers=whitelist_numbers) -> bool:
        for whitelist_number in whitelist_numbers:
            if n % whitelist_number == 0:
                return True
        else:
            return False
    return filter_condition


if __name__ == '__main__':
    only_3_and_5_condition = condition([3, 5])
    print(sum_below(10, only_3_and_5_condition))
    assert 23 == sum_below(10, only_3_and_5_condition)
    print(sum_below(1000, only_3_and_5_condition))
    assert 233168 == sum_below(1000, only_3_and_5_condition)

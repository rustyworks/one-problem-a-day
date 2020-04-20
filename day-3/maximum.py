from typing import Any


class Maximum:

    def get_highest(self, array: list, n: int = 1) -> Any:
        highest = [None, None]
        for element in array:
            if highest[0] is None:
                highest[0] = element
            elif highest[1] is None and element != highest[0]:
                highest[1] = element
            elif element > highest[0]:
                highest[1] = highest[0]
                highest[0] = element
        return highest[n-1]


if __name__ == '__main__':
    maximum = Maximum()
    print(maximum.get_highest([3, -2], 2))
    assert -2 == maximum.get_highest([3, -2], 2)
    print(maximum.get_highest([5, 5, 4, 4, 3], 2))
    assert 4 == maximum.get_highest([5, 5, 4, 4, 3], 2)
    print(maximum.get_highest([2, 2, 2, 2, 2], 2))
    assert None is maximum.get_highest([2, 2, 2, 2, 2], 2)
    print(maximum.get_highest([], 2))
    assert None is maximum.get_highest([], 2)

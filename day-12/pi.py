from decimal import Decimal
import math


def pi_func(i, depth):
    if depth == 1:
        return 0
    else:
        return Decimal('1') + i / (Decimal('2.0') * i + Decimal('1')) * pi_func(i + Decimal('1'), depth - 1)  # noqa


pi = 2 * pi_func(Decimal('1'), 100)
print(math.pi)
print(pi)

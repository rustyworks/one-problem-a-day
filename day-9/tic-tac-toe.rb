class TTicTacToe
  def check_winner(str)
    matrix = build_matrix(str)
    winner_1 = check_row(matrix)
    winner_2 = check_diagonal(matrix)
    winner_3 = check_row(matrix.transpose)
    x_win = winner_1[0] || winner_2[0] || winner_3[0]
    o_win = winner_1[1] || winner_2[1] || winner_3[1]

    if x_win && o_win
      'Draw'
    elsif x_win
      'X Win'
    elsif o_win
      'O Win'
    else
      'Draw'
    end
  end

  def build_matrix(str)
    matrix = []
    rows = []
    idx = 1
    str.split('').each do |x|
      rows << x
      if idx % 3 == 0
        matrix << rows
        rows = []
      end
      idx += 1
    end

    matrix
  end

  def check_row(matrix)
    x_win = false
    o_win = false
    matrix.each do |row|
      if all?(row, 'X')
        x_win = true
      end
      if all?(row, 'O')
        o_win = true
      end
    end
    return [x_win, o_win]
  end

  def check_diagonal(matrix)
    diag_1 = [matrix[0][0], matrix[1][1], matrix[2][2]]
    diag_2 = [matrix[2][0], matrix[1][1], matrix[0][2]]
    x_win = false
    o_win = false
    if all?(diag_1, 'X') || all?(diag_2, 'X')
      x_win = true
    end
    if all?(diag_1, 'O') || all?(diag_2, 'O')
      o_win = true
    end

    return [x_win, o_win]
  end

  def all?(row, element)
    row.each do |x|
      if (x != element) && (x != 'T')
        return false
      end
    end
    return true
  end
end

tttt = TTicTacToe.new
puts tttt.check_winner('XTX_OO___')
puts tttt.check_winner('X__O_OTOX')
puts tttt.check_winner('O__OXOTOX')
puts tttt.check_winner('X__OXOTOX')

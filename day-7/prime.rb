class Prime
  def initialize
    @prime_seq = [2]
  end

  def get_prime_until(limit)
    @limit = limit
    if @limit > @prime_seq.last
      generate_prime
    else
      @prime_seq.select { |x| x < @limit}
    end
  end

  def generate_prime
    (2..@limit).each do |n|
      @prime_seq << n if is_prime?(n)
    end
    @prime_seq
  end

  def is_prime?(n)
    @prime_seq.each do |prime|
      if n % prime == 0
        return false
      end
    end
    return true
  end
end

prime = Prime.new
p prime.get_prime_until 10
p prime.get_prime_until 10000
p prime.get_prime_until 10000

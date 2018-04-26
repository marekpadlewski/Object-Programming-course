module FixnumExtended
  class ::Fixnum
    def initialize(number)
      @number = number
    end

    def czynniki
      output = []
      1.upto(Math.sqrt(self)) do |x|
        next unless (self % x).zero?
        output.push(x)
        candidate = self / x
        output.push(candidate) unless candidate == x
      end
      output
    end

    def ack(y)
      if zero?
        y + 1
      elsif y.zero?
        (self - 1).ack(1)
      else
        argument = ack(y - 1)
        (self - 1).ack(argument)
      end
    end

    def doskonala
      divisors = []
      2.upto(Math.sqrt(self)) do |x|
        next unless (self % x).zero?
        divisors.push(x)
        candidate = self / x
        divisors.push(candidate) unless candidate == x
      end
      sum = 1
      divisors.each { |n| sum += n }
      sum == self
    end


    def slownie
      slownik = { 1 => 'jeden',
                  2 => 'dwa',
                  3 => 'trzy',
                  4 => 'cztery',
                  5 => 'pięć',
                  6 => 'sześć',
                  7 => 'siedem',
                  8 => 'osiem',
                  9 => 'dziewięć',
                  0 => 'zero'
      }
      output = ''
      input = to_s.chars.map(&:to_i)
      input.each { |n| output += slownik[n] += ' ' }
      output
    end

  end
end
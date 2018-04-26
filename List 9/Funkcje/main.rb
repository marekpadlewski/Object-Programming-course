require 'gruff'

def sign(x)
  x <=> 0
end

class Funkcja
  def initialize(block)
    @procedure = block
  end

  def wartosc(x)
    @procedure.call(x)
  end

  def arnosc
    @procedure.arity
  end

  def zerowe(a, b, e)
    if @procedure[a] == 0.0
      puts a
    end

    if @procedure[b] == 0.0
      puts b
    end

    while b-a > e
      srodek = (a+b)/2

      if @procedure[srodek] == 0.0
        puts srodek
      end

      if @procedure[a] * @procedure[srodek] < 0.0
        b = srodek

      else
      a = srodek

      end
    end

    puts (a+b)/2

  end


  def pole(a, b)
    przyblizenie = 100
    delta = 1.0 * (b - a) / przyblizenie
    powierzchnia = 0.0
    iterator = 0
    while iterator < przyblizenie
      left = a + iterator*delta
      right = left+delta
      powierzchnia += delta * @procedure.call((left+right)/2)
      iterator += 1
    end
    powierzchnia
  end

  def calka(x)
    przyblizenie = 0.0000000001
    (wartosc(x + przyblizenie) - wartosc(x)) / przyblizenie
  end



  def wykres(a, b, kroki)

    datapoints = []
    delta = 1.0 * (b - a) / kroki

    kroki.times do |x|
      left = a + x * delta
      right = left + delta
      datapoints[x] = @procedure.call((left + right) / 2)
    end

    width = 1000
    graph = Gruff::Line.new(width)
    graph.data('Wykres', datapoints)
    graph.write('test.png')
  end

end

funkcja = Funkcja.new(proc { |x| (x * x * x) })
puts funkcja.wartosc(3)
puts funkcja.pole(0, 4)
puts funkcja.calka(2)
funkcja.wykres(-4, 4, 10)
funkcja.zerowe(-2, 2, 0.00001)
class Jawna
  def initialize(text)
    @text = text
  end

  def encrypt(key)
    output = ''
    counter = 0

    while counter < @text.length
      output[counter] = key[@text[counter]]
      counter += 1
    end

    final = Zaszyfrowane.new(output)
  end

  def to_s()
    @text
  end

end


class Zaszyfrowane
  def initialize(text)
    @text = text
  end

  def decrypt(decryption_key)
    output = ''
    counter = 0

    while counter<@text.length
      output[counter] = decryption_key[@text[counter]]
      counter += 1
    end

    final = Jawna.new(output)
  end

  def to_s()
    @text
  end

end
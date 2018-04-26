require File.expand_path('encryption.rb')

to_encrypt = Jawna.new('test')

encryption_key = { 't' => 'a',
                   'e' => 'b',
                   's' => 'c'
}

decryption_key = { 'a' => 't',
                   'b' => 'e',
                   'c' => 's'
}

encrypted = to_encrypt.encrypt(encryption_key)
puts encrypted.to_s

puts encrypted.decrypt(decryption_key).to_s
def odd_or_even_sum(dice, num):
    num_str = str(num)
    odd_sum = 0
    even_sum = 0
    
    for i in range(len(num_str)):
        digit = int(num_str[i])
        if (i + 1) % 2 == 1:
            odd_sum += digit
        else:
            even_sum += digit
    
    if dice % 2 == 0:
        return odd_sum
    else:
        return even_sum

# Hard-coded input
dice = 5
num = 25469

result = odd_or_even_sum(dice, num)
print(result)

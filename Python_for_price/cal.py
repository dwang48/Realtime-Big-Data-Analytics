# import numpy
import csv

def calculator(output,price):
    for i in range(1,len(output)):
        state_code = int(output[i][0][1])*10+int(output[i][0][2])-1
        # if price[state_code]
        temp0 = output[i][0]
        temp1 = float(output[i][1])
        temp2 = float(output[i][2])  
        # wind energy is proportional to the cube of wind speed
        temp1 = float(price[state_code])*temp1**3/100 # convert cents to dollars
        # solar energy is proportional to direct normal irradiance
        temp2 = float(price[state_code])*temp2/100 # convert cents to dollars
        # print(state_code)
        # print(temp1)
        # print(temp2)
        output[i] = (temp0+',',str(temp1)+',',str(temp2)+"\n")
    return output
    

price = []

with open('electricity_price.csv', newline='') as elec_price:
    s = csv.reader(elec_price, delimiter=',', quotechar='|')
    count = 0
    for row in s:
        print(row)
        if count != 0:
            price.append(row[1])
        count += 1
        
        # print(', '.join(row))

# print(price)
# print("price: ", len(price))


weather = open('weatheravg.txt','r')
lines = weather.readlines()
output = []
for line in lines:
    tokens = line.split(' ')
    output.append((tokens[0].split('\t')[0],tokens[2],tokens[5]))
print(output)


# with open('first.txt','w') as file1:
#     for line in output:
#         file1.write(''.join(line))
print(output[0])
output = calculator(output,price)

with open('price.txt','w') as file2:
    for line in output:
        file2.write(''.join(line))
    

states = ["AL", "AK", "","AZ", "AR", "CA", "","CO", "CT", "DC", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"]
#        ["01", "02" ,"", "04", "05",  "06",   "08", "09", "11", "" ]



# print(len(states))


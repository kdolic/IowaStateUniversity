from flask import Flask, render_template, request

app = Flask(__name__)


@app.route('/')
def home():
    # Show the loan input form:
    return render_template("loan-form.html")


@app.route('/compute', methods=['POST'])
def compute():
    # For a POST request, request.form is a dictionary that contains the posted
    # form data. It will have string values for 'rate', 'years', and 'amount'.
    # These values below are just set to values so the code will run, but you need
    # to get the values from the request.form[] dictionary and convert to
    # int or float as needed.
    rate = float(request.form['rate'])
    years = int(request.form['years'])
    amount = float(request.form['amount'])
    monthlyRate = rate / 12.0
    month = years * 12
    payment = amount * ((monthlyrate * (1 + monthlyrate) ** months) / ((1 + monthlyrate) ** months - 1))
    total_interest = 0
    amort_table = []

balance = amount

for x in range(month):
    interestRate = balance * monthlyRate
    principal = payment - interestRate
    balance = balance += interestRate
    totInterest += interestRate
    amort_table.append(('month': i + 1, 'payment': payment, 'principal': principal, 'interest': interestRate, 'balance': balance))

    # Use the values to compute the payment.
    # Then loop over the months, compute the interest, payment, and
    # balance for the month:
   	#   interest = the balance times monthlyrate
   	#   principal = the payment minus interest
   	#   balance = balance minus principal
   	#   total_interest += interest
    #   And, add an entry to the amort_table list so it can be
    #   displayed on the output page:
    #     {'month': month, 'payment': payment, 'principal': principal,
    #      'interest': interest, 'balance': balance}
    #
    # After the loop is complete, render the output page. Send values for
    # the rate, years, amount, payment, and the amortization table:

    return render_template("loan-table.html", rate=rate, years=years,
                           amount=amount, payment=payment,
                           total_interest=total_interest,
                           amort_table=amort_table)


if __name__ == "__main__":
    app.run(debug=True, host='0.0.0.0', port=8080)
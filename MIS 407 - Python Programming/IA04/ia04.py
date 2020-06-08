"""Program that stores years, amount, rate, computes monthly payment & total interest paid with option to clear or exit application
User can:
    Enter Years
    Enter Amount
    Enter Rate
    Compute Monthly Payment
    Clear Data Entered
    Exit the application

NOTE: See wireframe.png for sketch of interface.

"""

from tkinter import *

window = Tk() # TK method that creates a windows object

def compute_command():
    amount_years = int(years_entry.get())
    amount_total = float(amount_entry.get())
    amount_rate = float(rate_entry.get())
    months = amount_years * 12
    total_interest = 0.0
    balance = amount_total
    current_month = 0

    for i in range(months):
        monthlyRate = amount_rate / 12.0
        payment = amount_total * ((monthlyRate * (1 + monthlyRate) ** months)) / ((1 + monthlyRate) ** months - 1)) 
        secondInterest = balance * monthlyRate
        principal = payment - secondInterest
        balance -= principal
        total_interest += secondInterest
        current_month += 1
        payment_entry.set(payment)
        tot_interest_entry.set(total_interest)
        list1.insert(END, (current_month, payment, principal, secondInterest, balance))
    pass

def clear_command():
    years_entry.set(0)
    amount_entry.set(0)
    rate_entry.set(0.0)
    payment_entry.set(0.0)
    tot_interest_entry.set(0.0)
    list1.delete(0, END)

l1=Label(window, text="Years")
l1.grid(row=0,column=0)

l2=Label(window, text="Amount")
l2.grid(row=1,column=0)

l3=Label(window, text="Rate")
l3.grid(row=2,column=0)

l3=Label(window, text="List box")
l3.grid(row=3,column=0)

l4=Label(window, text="Monthly Payment")
l4.grid(row=0,column=2)

l5=Label(window, text="Total Interest Paid")
l5.grid(row=1,column=2)

# Display text entry fields
years_entry=IntVar()
e1=Entry(window,textvariable=years_entry)
e1.grid(row=0,column=1)

amount_entry=IntVar()
e2=Entry(window,textvariable=amount_entry)
e2.grid(row=1,column=1)

rate_entry=DoubleVar()
e3=Entry(window,textvariable=rate_entry)
e3.grid(row=2,column=1)

payment_entry=DoubleVar()
e4=Entry(window,textvariable=payment_entry)
e4.grid(row=0,column=3)

tot_interest_entry=DoubleVar()
e5=Entry(window,textvariable=tot_interest_entry)
e5.grid(row=1,column=3)

# Display listbox and attached a Scrollbar
list1=Listbox(window, height=6, width=35)
list1.grid(row=4, column=0, rowspan = 10, columnspan= 4 ) 

sb1 = Scrollbar(window)
sb1.grid(row=2, column=4, rowspan=10)

list1.configure(yscrollcommand = sb1.set)
sb1.configure(command = list1.yview)

# Buttons
b1=Button(window, text="Compute", width=12, COMMAND = compute_command)
b1.grid(row=3, column=5)
b2=Button(window, text="Clear", width=12, COMMAND = clear_command)
b2.grid(row=4, column=5)
b3=Button(window, text="Exit", width=12, COMMAND = window.destroy)
b3.grid(row=5, column=5)

window.mainloop()
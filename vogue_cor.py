import pandas as pd
from pandas.plotting import scatter_matrix
import numpy as np
import matplotlib.pyplot as plt

data = pd.read_csv("request_emotions.csv", delimiter="|", encoding="utf-8")

# Linear correlation matrix: x increases, y also increases
correlation_matrix = data.corr()
selected_column = "PersonaTurn_IsTalking"
print("Showing linear correlation matrix, corr matrix: {}".format(selected_column))
print(correlation_matrix[selected_column].sort_values(ascending=False))

attributes_to_show = ["PersonaTurn_IsTalking",
                      "Persona_Turn_Negativity",
                      "UserTurn_IsAttentive",
                      "UserTurn_IsTalking",
                      "User_Turn_Negativity",
                      "User_Turn_Positivity"]

# scatter_matrix(data[attributes_to_show])
# plt.show()
data = data.sort_values(by="Time", ascending=True)

# Make it pretty
plt.style.use('seaborn-darkgrid')

# create a color palette
palette = plt.get_cmap('Set1')

# multiple line plot
num = 0
for column in data.drop('Time', axis=1):
    num += 1
    plt.plot(data['Time'], data[column], marker='', color=palette(num), linewidth=1, alpha=0.9, label=column)

# Add legend
plt.legend(loc=2, ncol=2)

# Add titles
plt.title("A (bad) Spaghetti plot", loc='left', fontsize=12, fontweight=0, color='orange')
plt.xlabel("Time")
plt.ylabel("Score")
plt.show()
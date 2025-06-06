#!/bin/bash

while true; do
  echo ""
  echo "Which project would you like to run?"
  echo "-----------------------------------"
  echo ""
  echo "1. RealConstructor1"
  echo "2. LemigoHotel1" 
  echo "3. RwandaPolice"
  echo ""
  read -p "Enter choice (hit Enter to 'Exit'): " choice

  case $choice in
    1)
      echo "Opening the Real Constructor ..."
      echo ""
      cd RealConstructor1
      javac -d . $(find . -name "*.java")
      java RealConstructor1.main.Main2
      break
      ;;
    2)
      echo "Opening the Lemigo Hotel ..."
      echo ""
      cd LemigoHotel1  
      javac -d . $(find . -name "*.java")
      java LemigoHotel1.main.Main1
      break
      ;;
    3)
      echo "Opening the Rwanda Police ..."
      echo ""
      cd RwandaPolice
      javac -d . $(find . -name "*.java") 
      java RwandaPolice.main.Main
      break
      ;;
    "")
      echo ""
      echo "Bye....."
      exit 0
      ;;
    *)
      echo ""
      echo "Invalid choice. Please try again."
      ;;
  esac
done
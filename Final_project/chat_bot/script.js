// For vercel hosted version
const apiUrl =
  "https://cors-anywhere.herokuapp.com/https://ugg4ooccg8gws0cwc8g04ko0.loki.vanhansewijck.com/api/chat/one";

// Function to send the message
async function sendMessage() {
  const userInput = document.getElementById("user-input");
  const chatBox = document.getElementById("chat-box");
  const loadingSpinner = document.getElementById("loading-spinner");

  if (!userInput.value.trim()) return;
  const userInputHolder = userInput.value;

  // Clear input field
  userInput.value = "";

  // Display user message
  const userMessage = document.createElement("div");
  userMessage.className = "message user-message";
  userMessage.innerText = userInputHolder;
  chatBox.appendChild(userMessage);

  // Show the loading spinner while waiting for the response
  loadingSpinner.style.display = "block";

  try {
    const response = await fetch(apiUrl, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ content: userInputHolder }),
    });

    if (!response.ok) throw new Error("API request failed");

    const data = await response.json();

    // Display bot response
    const botMessage = document.createElement("div");
    botMessage.className = "message bot-message";
    botMessage.innerHTML = data.content; // Supports links
    chatBox.appendChild(botMessage);

    // Scroll chat to the latest message
    chatBox.scrollTop = chatBox.scrollHeight;
  } catch (error) {
    console.error("Error:", error);
    const errorMessage = document.createElement("div");
    errorMessage.className = "message bot-message";
    errorMessage.style.color = "red";
    errorMessage.innerText = "Error connecting to the chatbot.";
    chatBox.appendChild(errorMessage);
  } finally {
    // Hide the loading spinner after the response
    loadingSpinner.style.display = "none";
  }
}

// Add an event listener to listen for the Enter key
document
  .getElementById("user-input")
  .addEventListener("keypress", function (e) {
    if (e.key === "Enter") {
      sendMessage();
    }
  });

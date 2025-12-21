FROM python:3.11-slim

# Set working directory
WORKDIR /app

# Copy requirements file
COPY requirements.txt .

# Install dependencies
RUN pip install --no-cache-dir -r requirements.txt

# Copy application files
COPY . .

# Expose port 8501 (Streamlit default)
EXPOSE 8000


# Run Streamlit application
CMD ["uvicorn", "api:app", "--host", "0.0.0.0", "--port", "8000"]

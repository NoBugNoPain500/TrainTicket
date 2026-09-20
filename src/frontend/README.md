src/
├── app/
│ ├── providers/
│ │ ├── QueryProvider.tsx
│ │ ├── RouterProvider.tsx
│ │ └── AuthProvider.tsx
│ │
│ ├── router/
│ │ ├── index.tsx
│ │ └── routes.tsx
│ │
│ └── App.tsx
│
├── features/
│ ├── auth/
│ │ ├── api/
│ │ │ └── auth.api.ts
│ │ ├── components/
│ │ │ ├── LoginForm.tsx
│ │ │ └── RegisterForm.tsx
│ │ ├── hooks/
│ │ │ └── useAuth.ts
│ │ ├── types/
│ │ │ └── auth.types.ts
│ │ └── index.ts
│ │
│ ├── movie/
│ │ ├── api/
│ │ ├── components/
│ │ ├── hooks/
│ │ ├── types/
│ │ └── index.ts
│ │
│ └── booking/
│ ├── api/
│ ├── components/
│ ├── hooks/
│ ├── types/
│ └── index.ts
│
├── pages/
│ ├── LoginPage/
│ │ └── LoginPage.tsx
│ ├── HomePage/
│ │ └── HomePage.tsx
│ ├── MoviePage/
│ │ └── MoviePage.tsx
│ └── BookingPage/
│ └── BookingPage.tsx
│
├── components/
│ ├── ui/
│ │ ├── Button.tsx
│ │ ├── Input.tsx
│ │ ├── Modal.tsx
│ │ └── Select.tsx
│ │
│ ├── layout/
│ │ ├── Header.tsx
│ │ ├── Sidebar.tsx
│ │ └── Footer.tsx
│ │
│ └── common/
│ ├── Loading.tsx
│ ├── ErrorMessage.tsx
│ └── EmptyState.tsx
│
├── lib/
│ ├── axios.ts
│ ├── queryClient.ts
│ └── storage.ts
│
├── hooks/
│ ├── useDebounce.ts
│ └── usePagination.ts
│
├── types/
│ ├── api.ts
│ └── common.ts
│
├── constants/
│ ├── routes.ts
│ └── config.ts
│
├── utils/
│ ├── date.ts
│ ├── format.ts
│ └── validation.ts
│
├── styles/
│ ├── globals.css
│ └── variables.css
│
└── main.tsx

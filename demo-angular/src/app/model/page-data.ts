import { UserData } from './user-data';

export interface PageData {

  currentPage: number;
  pageSize: number;
  totalElements: number;
  totalPages: number;
  showFirst: boolean;
  showPrevious: boolean;
  showNext: boolean;
  showLast: boolean;
  pageSizeList: number[];
  currentShowFromEntries: number;
  currentShowToEntries: number;
  sort: string;
  order: string;
  items: UserData[];
}
